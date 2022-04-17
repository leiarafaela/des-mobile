package br.com.mobile.thenulos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.tabs.TabLayout

class DebugActivity : AppCompatActivity() {

    private val TAG = "TheNulos"
    private val className: String
        get() {
            val s = javaClass.name
            return s.substring(s.lastIndexOf("."))
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}