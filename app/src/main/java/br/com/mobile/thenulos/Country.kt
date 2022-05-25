package br.com.mobile.thenulos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "paises")
class   Country: Serializable {

    @PrimaryKey
    var id: Long = 0
    var pais: String = ""
    var capital: String = ""
    var bandeira: String = ""
    var continente: String = ""
    var populacao: String = ""
    var latitude: String = ""
    var longitude: String = ""

    override fun toString(): String{
        return "País(nome='$pais')"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}