package com.mauri.presentacion3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {


    val comidaList= mutableListOf<Comida>( )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val r = findViewById<RecyclerView>(R.id.recycler1)
// mostrar
        listar();
        val comidasAdapter = ComidasAdapter(applicationContext,comidaList)
        r.adapter = comidasAdapter
        val layout = LinearLayoutManager(applicationContext)
        layout.orientation = LinearLayoutManager.VERTICAL
        r.layoutManager = layout

        //boton agregar
        val btnAgregar:FloatingActionButton=findViewById(R.id.agregar)
        btnAgregar.setOnClickListener{

            val intenet=Intent(this,ModificarActivity::class.java)
            startActivity(intenet)
        }
    }

    fun listar(){

        ComidaApp.db.comidasDao()
        var personasList : List<Comida> =
            ComidaApp.db.comidasDao().selectPersonas()
        for (p in personasList){
            Log.i("base","Agregada la comida ${p.nombre}")
            comidaList.add(p)
        }
    }

    fun removeComida(position: Int) {
        Log.i("entra  ","elimidado")

        comidaList.removeAt(position)
        // Notificar al adaptador del RecyclerView de los cambios


    }

}