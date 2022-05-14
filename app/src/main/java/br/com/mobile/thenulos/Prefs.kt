package br.com.mobile.thenulos

import android.content.Context
import android.content.SharedPreferences

object Prefs {

    val PREF_ID = "TheNulos"

    // retorna o armazém de preferências PREF_ID
    private fun prefs(): SharedPreferences {
        val context = TheNulosApplication.getInstance().applicationContext
        val prefs = context.getSharedPreferences(PREF_ID, 0)
        return prefs
    }

    fun setString(flag: String, valor: String) {
        return  prefs().edit().putString(flag, valor).apply()
    }

    fun getString(flag: String): String?{
        return prefs().getString(flag, "")
    }

    fun setBoolean(flag: String, valor: Boolean){
        return prefs().edit().putBoolean(flag, valor).apply()
    }

    fun getBoolean(flag: String) : Boolean?{
        return prefs().getBoolean(flag, false)
    }
}