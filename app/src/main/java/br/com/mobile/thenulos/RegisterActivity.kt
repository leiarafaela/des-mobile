package br.com.mobile.thenulos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    val contexto : Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar?.title = "Cadastro"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        fun onClickLocalization() {
//            Toast.makeText(this, "Salvando País", Toast.LENGTH_SHORT).show()
//            val intent = Intent(this, HomeScreenActivity::class.java)
//            startActivity(intent)
//        }
        salvarPais.setOnClickListener{

            Toast.makeText(this, "Salvando país", Toast.LENGTH_SHORT)
            val paises = Country()
            paises.pais = PaisNome.text.toString()
            paises.capital = PaisCapital.text.toString()
            paises.bandeira = PaisUrl.text.toString()
            paises.continente = PaisContinente.text.toString()
            paises.populacao = PaisPopulacao.text.toString()
            paises.latitude = PaisLatitude.text.toString()
            paises.longitude = PaisLongitude.text.toString()
            taskAtualizar(paises)
        }
    }

    private fun taskAtualizar(paises: Country) {
        // Thread para salvar a discilpina
        Thread {
            CountryService.save(paises)
            runOnUiThread {
                finish()
            }
        }.start()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
