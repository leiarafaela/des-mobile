package br.com.mobile.thenulos

import android.database.sqlite.SQLiteBindOrColumnIndexOutOfRangeException
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

object CountryService {

    val host = "https://gustavodovalle.pythonanywhere.com"
    val TAG = "WS_TheNulos"

    fun getCountry(): List<Country>{

        val url = "$host/paises"
        val json = HttpHelper.get(url)
        Log.d(TAG, json)
        return parserJson<List<Country>>(json)
    }

    inline fun <reified T> parserJson(json: String): T{
        val type = object: TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }

    fun save(paises: Country): Response {
        if (AndroidUtils.isInternetDisponivel()) {
            val json = HttpHelper.post("$host/paises", paises.toJson())
            return parserJson(json)
        }
        else {
            saveOffline(paises)
            return Response("OK", "País salvo no dispositivo")
        }
    }
    fun existePais(paises: Country): Boolean {
        val dao = DatabaseManager.getCountryDAO()
        return dao.getById(paises.id) != null
    }

    fun delete(paises: Country): Response {
        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/paises/${paises.id}"
            val json = HttpHelper.delete(url)

            return parserJson(json)
        } else {
            val dao = DatabaseManager.getCountryDAO()
            dao.delete(paises)
            return Response(status = "OK", msg = "Dados salvos localmente")
        }

    }

    fun saveOffline(paises: Country) : Boolean {
        val dao = DatabaseManager.getCountryDAO()

        if (! existePais(paises)) {
            dao.insert(paises)
        }

        return true

    }
}