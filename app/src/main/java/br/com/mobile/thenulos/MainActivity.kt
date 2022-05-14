package br.com.mobile.thenulos

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        if (Prefs.getBoolean("chkRemember") == true) {
            input_name.setText(Prefs.getString("nome"))
            input_password.setText(Prefs.getString("senha"))
            chkRememberMe.isChecked = true
        }

        fun onClickLogin() {
            val valorUser = input_name.text.toString()
            val valorPass = input_password.text.toString()
            //Toast.makeText(context, "$valorUsuario : $valorSenha", Toast.LENGTH_LONG).show()

            if (valorUser == "aluno" && valorPass == "impacta") {

                if (chkRememberMe.isChecked){
                    Prefs.setString("nome", valorUser)
                    Prefs.setString("senha", valorPass)
                    Prefs.setBoolean("chkRemember", chkRememberMe.isChecked)
                }
                else{
                    Prefs.setString("nome", "")
                    Prefs.setString("senha", "")
                    Prefs.setBoolean("chkRemember", chkRememberMe.isChecked)
                }

                // criar intent
                val intent = Intent(this, HomeScreenActivity::class.java)
                // colocar parâmetros (opcional)
                val params = Bundle()
                params.putString("nome", valorUser)

                intent.putExtras(params)

                // enviar parâmetros simplificado
                //intent.putExtra("numero", 10)

                // fazer a chamada
                //startActivity(intent)

                // fazer a chamada esperando resultado
                startActivityForResult(intent, 1)
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()
            }
        }

        button_login.setOnClickListener{onClickLogin()}

    }

}
