package br.com.mobile.thenulos

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class HomeScreenActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        supportActionBar?.title = "Home"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_buscar){
            Toast.makeText(this, "Buscar", Toast.LENGTH_LONG).show()

        } else if (id == R.id.action_atualizar){
            Toast.makeText(this, "Atualizar", Toast.LENGTH_LONG).show()

        } else if (id == R.id.action_adicionar){
            Toast.makeText(this, "Adicionar", Toast.LENGTH_LONG).show()
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        } else if (id == R.id.action_sair){
            Toast.makeText(this, "Sair", Toast.LENGTH_LONG).show()

        } else if (id == android.R.id.home)
            finish()

        return super.onOptionsItemSelected(item)
    }
}