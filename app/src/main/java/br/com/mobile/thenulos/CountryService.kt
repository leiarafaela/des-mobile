package br.com.mobile.thenulos

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Exception
import java.lang.reflect.Executable
import java.net.URL
import java.util.zip.CheckedOutputStream

object CountryService {

    val host = "https://gustavodovalle.pythonanywhere.com" //
    val TAG = "WS_TheNulos"

    fun getCountry (context: Context): List<Country> {
        var paises = ArrayList<Country>()
        try {
            val url = "$host/paises"
            val json = HttpHelper.get(url)
            paises = parserJson(json)
            for (d in paises) {
                saveOffline(d)
            }
            return paises
        } catch (ex: Exception){
            val dao = DatabaseManager.getCountryDAO()
            val paises = dao.findAll()
            return paises
        }
    }

    fun getPais (context: Context, id: Long): Country? {
        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/paises/${id}"
            val json = HttpHelper.get(url)
            val paises = parserJson<Country>(json)

            return paises
        } else {
            val dao = DatabaseManager.getCountryDAO()
            val paises = dao.getById(id)
            return paises
        }

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