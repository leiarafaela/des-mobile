package br.com.mobile.thenulos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.toolbar.*


class HomeScreenActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener{
    val contexto : Context get() = this
    private var paises = listOf<Country>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Home"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

        recyclerPaises?.layoutManager = LinearLayoutManager(this)
        recyclerPaises?.itemAnimator = DefaultItemAnimator()
        recyclerPaises?.setHasFixedSize(true)


    }
    override fun onResume() {
        super.onResume()
        taskCountrys()
    }

    fun taskCountrys()  {
        Thread{
            this.paises = CountryService.getCountry()

            runOnUiThread {
                recyclerPaises?.adapter = CountryAdapter(paises) {
                    onClickCountry(it)
                }
            }
        }.start()
    }

    fun onClickCountry(pais: Country){
        Toast.makeText(this, "Clicou na ${pais.pais}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, DetailActivity()::class.java)
        intent.putExtra("pais", pais)
        startActivity(intent)

    }

    private fun configuraMenuLateral(){
        val toogle = ActionBarDrawerToggle(
            this, layoutMenuLateral, toolbar, R.string.open, R.string.close)
        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when(item.itemId){
                R.id.nav_paises ->{
                    Toast.makeText(this, "Países", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, CountryActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_sobre ->{
                    Toast.makeText(this, "Sobre", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, AboutActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_sair ->{
                    Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView).setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                // ação enquanto está digitando
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                // ação  quando terminou de buscar e enviou
                Toast.makeText(contexto,  "Buscar: " + query, Toast.LENGTH_LONG).show()
                return true
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_buscar){
            Toast.makeText(this,  " Buscar", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_adicionar){
            Toast.makeText(this, "Adicionar", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        } else if (id == R.id.action_sair){
            Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        } else if (id == android.R.id.home)
            finish()

        return super.onOptionsItemSelected(item)
    }
}