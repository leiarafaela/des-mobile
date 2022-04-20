package br.com.mobile.thenulos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        button_login.setOnClickListener{
            val valorUser = input_name.text.toString()
            val valorPass = input_password.text.toString()
            Toast.makeText(this, "Autenticado",Toast.LENGTH_LONG).show()

        }

    }

}