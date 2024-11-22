package com.example.examenalexvallejolaguna

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonIniciar: ImageButton = findViewById(R.id.botonIniciar)

        botonIniciar.setOnClickListener{

            val intent = Intent(this,ListaActivity::class.java)
            startActivity(intent)
        }

    }
}