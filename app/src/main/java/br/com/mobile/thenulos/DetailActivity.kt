package br.com.mobile.thenulos

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.toolbar.*

class DetailActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Sobre o pais"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home)
            finish()

        return super.onOptionsItemSelected(item)
    }

    fun taskCountrys()  {
        Thread{
            paises = CountryService.getCountryId("2")

            runOnUiThread {
//                recyclerPaisesDetail?.adapter = CountryAdapter(paises) {
//
//                }
            }
        }.start()
    }

    private var paises = listOf<Country>()
    override fun onResume() {
        super.onResume()
        //taskCountrys()
    }
}