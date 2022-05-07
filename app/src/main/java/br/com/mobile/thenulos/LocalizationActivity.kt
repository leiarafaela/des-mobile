package br.com.mobile.thenulos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_localization.*
import kotlinx.android.synthetic.main.activity_register.*

class LocalizationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localization)


        supportActionBar?.title = "Localização"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            finish()
//        } else if (id == R.id.action_atualizar) {
//            Toast.makeText(this, "Atualizar", Toast.LENGTH_SHORT).show()
//            progressAtualizar3.visibility = View.VISIBLE
//            Handler(Looper.getMainLooper()).postDelayed(
//                {
//                    progressAtualizar3.visibility = View.GONE
//                }, 10000
//            )
        }

            return super.onOptionsItemSelected(item)
        }
}