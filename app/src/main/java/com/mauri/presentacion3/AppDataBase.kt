package com.mauri.presentacion3

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Comida::class],version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun comidasDao(): ComidaDao
}
