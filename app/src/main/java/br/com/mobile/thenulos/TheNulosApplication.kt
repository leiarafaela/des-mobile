package br.com.mobile.thenulos

import android.app.Application
import java.lang.IllegalStateException

class TheNulosApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

     companion object{
         private var appInstance: TheNulosApplication? = null

         fun getInstance(): TheNulosApplication{
             if (appInstance == null){
                 throw IllegalStateException("Configurar application")
             }
             return appInstance!!
         }
     }
}