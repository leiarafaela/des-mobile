package br.com.mobile.thenulos

import androidx.room.Room

object DatabaseManager {
    // singleton
    private var dbInstance: TheNulosDatabase
    init {
        val appContext = TheNulosApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            appContext, // contexto global
            TheNulosDatabase::class.java,
            "TheNulos.sqlite").build()
    }

    fun getCountryDAO(): CountryDAO {
        return dbInstance.countryDAO()
    }

}