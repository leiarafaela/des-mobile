package br.com.mobile.thenulos

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

object CountryService {

    val host = "https://gustavodovalle.pythonanywhere.com"
    val TAG = "WS_TheNulos"

    fun getCountry(): List<Country>{

        //val paises = mutableListOf<Country>()
        val url = "$host/paises"
        val json = URL(url).readText()
        Log.d(TAG, json)

        return parserJson<List<Country>>(json)
    }

//    fun getCountryId(id: String): List<Country>{
//
//        //val paises = mutableListOf<Country>()
//        val url = "$host/paises/$id"
//        val json = URL(url).readText()
//        Log.d(TAG, json)
//
//        return parserJson<List<Country>>(json)
//    }

    inline fun <reified T> parserJson(json: String): T{
        val type = object: TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}