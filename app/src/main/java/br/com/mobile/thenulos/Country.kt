package br.com.mobile.thenulos

import java.io.Serializable

class Country: Serializable {

    var id: String = ""
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
}