package br.com.mobile.thenulos

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Country::class), version = 1)
abstract class TheNulosDatabase: RoomDatabase() {
    abstract fun countryDAO(): CountryDAO

}