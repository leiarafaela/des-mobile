package br.com.mobile.thenulos

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.toolbar.*

class DetailActivity : DebugActivity() {

    var pais: Country? = null
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        pais = intent.getSerializableExtra("pais") as Country

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Detalhes"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        nomePais.text = "País: ${pais?.pais}"
        nomeCapital.text = "Capital: ${pais?.capital}"
        nomeContinente.text = "Continente: ${pais?.continente}"
        nomePopulacao.text = "População: ${pais?.populacao}"
        nomeLatitude.text = "Latitude: ${pais?.latitude}"
        nomeLogintude.text = "Longitude: ${pais?.longitude}"

        Picasso.with(this).load(pais?.bandeira).fit().into(imagemPais,
            object: com.squareup.picasso.Callback{
                override fun onSuccess() {}

                override fun onError() { }
            })

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home)
            finish()

        return super.onOptionsItemSelected(item)

    }

}