package com.mauri.presentacion3

import android.app.Application
import androidx.room.Room

class ComidaApp:Application () {
    companion object{
        lateinit var db :AppDatabase
    }
    override fun onCreate() {
        super.onCreate()
        ComidaApp.db =
            Room.databaseBuilder(applicationContext,AppDatabase::class.java,
                "comidas.db"
            )
                .fallbackToDestructiveMigration() // para destruir todos los datos almigrar de una version a otra
                .allowMainThreadQueries() // para habilitar consultas a la db en elthread principal
                .build()
    }
}
