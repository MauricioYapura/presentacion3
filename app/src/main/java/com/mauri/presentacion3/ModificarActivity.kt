package com.mauri.presentacion3

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ModificarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_modificar)

        val textNombre= findViewById<EditText>(R.id.editTextName)
        val textPrecio= findViewById<EditText>(R.id.editTextPrecio)
        val textImagen= findViewById<EditText>(R.id.editTextImagen)
        val botomAgregar= findViewById<Button>(R.id.btnAgregar)
        botomAgregar?.setOnClickListener{

            insert(textNombre.text.toString(),textPrecio.text.toString())
        }


    }

    fun insert(nombre: String, precio: String) {
        val nuevaComida = Comida(
            nombre = nombre,
            precio = precio,
            imagen = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyYJM5184FuanrjIGqrTVbjfNP5eKihSpFwDHI3z3EnA&s"
        )

        ComidaApp.db.comidasDao().insertPersona(nuevaComida)
        Log.i("Marcela","Agregada la comida ${nuevaComida.nombre}")
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        // Iniciar MainActivity
        startActivity(intent)

        // Finalizar ModificarActivity para que no esté en la pila de actividades
        finish()
    }
}