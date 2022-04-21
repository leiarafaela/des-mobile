package br.com.mobile.thenulos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.login.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar?.title = "Cadastro"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home){
            finish()
        } else if (id == R.id.action_atualizar){
            Toast.makeText(this, "Atualizar", Toast.LENGTH_SHORT).show()
            progressAtualizar.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    progressAtualizar.visibility = View.GONE
                }, 10000
            )
        }
        else if (id == R.id.action_buscar){

            Toast.makeText(this, " Buscar", Toast.LENGTH_LONG).show()

        }
        else if (id == R.id.action_sair) {
            Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        return super.onOptionsItemSelected(item)

    }

}
