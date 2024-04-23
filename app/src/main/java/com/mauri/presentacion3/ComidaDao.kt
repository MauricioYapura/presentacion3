package com.mauri.presentacion3

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
public interface ComidaDao {
    @Query("select * from comida")
    fun selectPersonas(): List<Comida>
    @Insert
    fun insertPersona( com: Comida)
    @Update
    fun updatePersona(p: Comida)
    @Query("select * from comida where id=:id")
    fun selecPersonaBydId(id:Long):Comida
    @Query("update comida set nombre=:nombre where id=:id")
    fun updateNombre(id:Long,nombre:String)
    @Query("DELETE FROM comida WHERE id = :id")
    fun deleteComidaById(id: Long): Int
}
