package br.com.mobile.thenulos

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
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
            object : com.squareup.picasso.Callback {
                override fun onSuccess() {}

                override fun onError() {}

            }
        )
        fun onClickLocalization() {
            Toast.makeText(this, "Localizando...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LocalizationActivity::class.java)
            startActivity(intent)

        }
        button_localizacao.setOnClickListener{onClickLocalization()}

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ud, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            finish()
        }
        else if (id == R.id.action_deletar) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Deletar país")
            builder.setMessage("Você deseja excluir o país?")
            builder.setPositiveButton("Sim") { dialog, which ->
                Toast.makeText(this, "País deletado com sucesso", Toast.LENGTH_SHORT).show()
                taskExcluir()
            }
            builder.setNegativeButton("Não") { dialog, which ->
                Toast.makeText(this, "Ok! Não vamos excluir o país!", Toast.LENGTH_SHORT).show()

            }

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
        else if (id == R.id.action_alterar) {
            Toast.makeText(this, "Em desenvolvimento, aguarde!", Toast.LENGTH_LONG).show()
        }
            return super.onOptionsItemSelected(item)
    }


//    private fun taskExcluir(paises: Country) {
//        // Thread para salvar a discilpina
//        Thread {
//            CountryService.delete(paises)
//            runOnUiThread {
//                finish()
//            }
//        }.start()
//    }
    private fun taskExcluir() {
        if (this.pais != null && this.pais is Country) {
            // Thread para remover a disciplina
            Thread {
                CountryService.delete(this.pais as Country)
                runOnUiThread {
                    // após remover, voltar para activity anterior
                    finish()
                }
            }.start()
        }
    }



}
