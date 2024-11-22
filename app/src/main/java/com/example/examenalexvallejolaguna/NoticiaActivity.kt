package com.example.examenalexvallejolaguna

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NoticiaActivity : AppCompatActivity() {

    private lateinit var textoTitulo: TextView
    private lateinit var textoContenido: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticia)


        textoTitulo = findViewById<TextView>(R.id.textoTitulo)
        textoContenido = findViewById<TextView>(R.id.textoContenido)
        val botonCompartir = findViewById<Button>(R.id.botonCompartir)

        val tituloRecibido = intent?.getStringExtra(getString(R.string.campoIntentTitulo)) ?: getString(
            R.string.nadarecibido
        )
        textoTitulo.text = tituloRecibido

        val contenidoRecibido = intent?.getStringExtra(getString(R.string.campoIntentContenido)) ?: getString(R.string.nadarecibido)
        textoContenido.text = contenidoRecibido

        botonCompartir.setOnClickListener {
            val titulo: String = textoTitulo.text.toString()
            val contenido: String = textoContenido.text.toString()
            val datos: String = titulo + " " + contenido
            val email: String = getString(R.string.ejemploMail)
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"+email))
            intent.putExtra(Intent.EXTRA_TEXT, datos)

            val chooser = Intent.createChooser(intent, getString(R.string.abrircon))
            startActivity(chooser)
        }
    }

}