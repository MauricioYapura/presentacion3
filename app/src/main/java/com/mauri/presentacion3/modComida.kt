package com.mauri.presentacion3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class modComida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mod_comida)
        val txtNom=findViewById<EditText>(R.id.editTextName1)
        val txtPrecio=findViewById<EditText>(R.id.editTextPrecio1)
        val txtImagen=findViewById<EditText>(R.id.editTextImagen1)
        val btnModificar=findViewById<Button>(R.id.btnMod)
        val id = intent.getLongExtra("id", -1)
        val nombre = intent.getStringExtra("nombre")
        val precio = intent.getStringExtra("precio")
        val imagen = intent.getStringExtra("imagen")
        Log.i("patalla modificado","$precio")

        txtNom.setText(nombre)
        txtPrecio.setText(precio)
        txtImagen.setText(imagen)

                btnModificar.setOnClickListener{
                    val nombreNuevo = txtNom.text.toString()
                    val precioNuevo = txtPrecio.text.toString()
                    val imagenNuevo = txtImagen.text.toString()
                    Log.i("modComida", "ID: $id")
                    Log.i("modComida", "Nombre: $nombreNuevo")
                    Log.i("modComida", "Precio: $precioNuevo")
                    Log.i("modComida", "Imagen: $imagenNuevo")
                    val modificadoComida = Comida(
                        id=id,
                        nombre = nombreNuevo,
                        precio = precioNuevo,
                        imagen = imagenNuevo
                    )
                    ComidaApp.db.comidasDao().updatePersona(modificadoComida)
                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    // Iniciar MainActivity
                    startActivity(intent)

                    // Finalizar ModificarActivity para que no esté en la pila de actividades
                    finish()
                }
    }
}