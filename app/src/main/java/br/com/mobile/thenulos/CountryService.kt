package br.com.mobile.thenulos

object CountryService {

    fun getCountry(): List<Country>{
        val paises = mutableListOf<Country>()
        for (i in 1..10){
            val p = Country()
            p.nome = "País $i"
            p.bandeira = "https://static.todamateria.com.br/upload/ba/nd/bandeira-do-brasil-og.jpg"
            p.capital = "Capital $i"
            p.continente = "Continente $i"
            p.populacao = "População $i"
            p.latitude = "Latitude $i"
            p.longitude = "Longitude $i"

            paises.add(p)
        }
        return paises
    }
}