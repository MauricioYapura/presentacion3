package com.mauri.presentacion3

import androidx.room.Entity
import androidx.room.PrimaryKey

//data class Comida(var nombre)
@Entity
data class Comida(
    @PrimaryKey(autoGenerate = true) val id: Long=0,
    var nombre: String? = null,
    var precio: String? = null,
    var imagen: String? = null
){
    override fun toString(): String {
        return nombre ?: ""
    }
}
