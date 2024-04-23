package com.mauri.presentacion3

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ComidasAdapter (ctx: Context, private val comidasModel: List<Comida> ): RecyclerView.Adapter<ComidasAdapter.ComidasViewHolder>(){
    inner class ComidasViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var imageUrl = itemView.findViewById<ImageView>(R.id.imageComida)
        var titulo = itemView.findViewById<TextView>(R.id.txtTitulo)
        var descripcion = itemView.findViewById<TextView>(R.id.txtDes)
        var btnEliminar= itemView.findViewById<Button>(R.id.btnEliminar)
        var btnModificar= itemView.findViewById<Button>(R.id.btnModificar)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComidasViewHolder {
        val v = LayoutInflater.from (parent.context).inflate(R.layout.item_comida,parent,false)
        return ComidasViewHolder(v)
    }
    override fun getItemCount(): Int {
        return comidasModel.size
    }
    override fun onBindViewHolder(holder: ComidasViewHolder, position: Int) {
        val i = comidasModel[position]

        holder.btnEliminar.setOnClickListener {
            // Captura los datos de la comida correspondiente y muestra un log
            Log.i("eliminar", "Comida seleccionada:id:${i.id} con pission $position")
            var idDelete=i.id
            eliminarComida(idDelete )
            (holder.itemView.context as MainActivity).removeComida(position)
        }

        holder.btnModificar.setOnClickListener {
            // Captura los datos de la comida correspondiente y muestra un log

            Log.i("modificar", "Comida seleccionada:id:${i.id} ${i.nombre}, Precio: ${i.precio}")
            var idDelete=i.id

            val intent = Intent(holder.itemView.context, modComida::class.java)
            intent.putExtra("id", idDelete)
            intent.putExtra("nombre", i.nombre)
            intent.putExtra("precio", i.precio)
            intent.putExtra("imagen", i.imagen)
            holder.itemView.context.startActivity(intent)
        }
        holder.titulo.text = i.nombre
        holder.descripcion.text = i.precio
        Glide.with(holder.itemView.context)
            .load(i.imagen
                ,)
            .centerCrop()
//.placeholder(R.drawable.loading_spinner)
            .into(holder.imageUrl)
    }
    private fun eliminarComida(id:Long) {
        val comidaDao = ComidaApp.db.comidasDao()
        comidaDao.deleteComidaById(id)
        notifyItemRemoved(id.toInt())
    }
}
