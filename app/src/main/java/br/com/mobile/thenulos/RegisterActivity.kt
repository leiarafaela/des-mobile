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

        fun onClickLocalization() {
            Toast.makeText(this, "Salvando País", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeScreenActivity::class.java)
            startActivity(intent)
// falta implementar a inclusão via api
        }
        salvarPais.setOnClickListener{onClickLocalization()}
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home){
            finish()
        }
        //if (id == R.id.action_buscar){
        //    Toast.makeText(this,  " Buscar", Toast.LENGTH_LONG).show()
        //} else if (id == R.id.action_atualizar){
        //    Toast.makeText(this, "Atualizar", Toast.LENGTH_SHORT).show()
        //    progressAtualizar2.visibility = View.VISIBLE
        //    Handler(Looper.getMainLooper()).postDelayed(
        //        {
        //            progressAtualizar2.visibility = View.GONE
        //        }, 10000
        //    )
        //} else if (id == R.id.action_adicionar){
        //    Toast.makeText(this, "Adicionar", Toast.LENGTH_SHORT).show()
        //    val intent = Intent(this, RegisterActivity::class.java)
        //    startActivity(intent)
//
        //} else if (id == R.id.action_sair){
        //    Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()
        //    val intent = Intent(this, MainActivity::class.java)
        //    startActivity(intent)
//

        return super.onOptionsItemSelected(item)
    }
}
