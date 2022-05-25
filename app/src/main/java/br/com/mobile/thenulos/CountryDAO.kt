package br.com.mobile.thenulos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CountryDAO {

    @Query("SELECT * FROM paises where id = :id")
    fun getById(id: Long) : Country?

    @Query("SELECT * FROM paises")
    fun findAll(): List<Country>

    @Insert
    fun insert(paises: Country)

    @Delete
    fun delete(paises: Country)
}