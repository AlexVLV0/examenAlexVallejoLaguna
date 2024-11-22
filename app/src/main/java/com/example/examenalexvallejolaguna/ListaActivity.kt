package com.example.examenalexvallejolaguna

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ListaActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private val categorias = arrayOf(
        getString(R.string.todas),
        getString(R.string.politica),
        getString(R.string.economia),
        getString(R.string.cultura),
        getString(R.string.deportes)
    )

    private val tituloNoticias = arrayOf(
        getString(R.string.titulonoticiapol_tica),
        getString(R.string.titulonoticiaeconomia),
        getString(R.string.titulonoticiacultura),
        getString(R.string.titulonoticiadeportes),
    )

    private val contenidoNoticias = arrayOf(
        getString(R.string.contenidonoticiapol_tica),
        getString(R.string.contenidonoticiaeconomia),
        getString(R.string.contenidonoticiacultura),
        getString(R.string.contenidonoticiadeportes),
    )

    private val images = intArrayOf(
        R.drawable.cyltv,
        R.drawable.ic_politics,
        R.drawable.ic_economy,
        R.drawable.ic_culture,
        R.drawable.ic_sports

    )


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        val listaNoticias = findViewById<ListView>(R.id.listViewNoticias)
        val selectorCategorias = findViewById<Spinner>(R.id.spinnerCategorias)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tituloNoticias)
        listaNoticias.adapter = adapter

        val adaptadorPersonalizado = AdaptadorPersonalizado(this, R.layout.lineaspiner, categorias)
        selectorCategorias.adapter = adaptadorPersonalizado
        selectorCategorias.onItemSelectedListener = this

        listaNoticias.onItemClickListener = AdapterView.OnItemClickListener{ _, _, position, _ ->
            if(position != 1){
                val intent = Intent(this, NoticiaActivity::class.java)
                when (position){
                    0 ->{
                        intent.putExtra(getString(R.string.campoIntentTitulo),tituloNoticias[0])
                        intent.putExtra(getString(R.string.campoIntentContenido), contenidoNoticias[0])
                        startActivity(intent)

                    }
                    1 -> {
                        intent.putExtra(getString(R.string.campoIntentTitulo),tituloNoticias[1])
                        intent.putExtra(getString(R.string.campoIntentContenido), contenidoNoticias[1])
                        startActivity(intent)
                    }
                    2-> {
                        intent.putExtra(getString(R.string.campoIntentTitulo),tituloNoticias[2])
                        intent.putExtra(getString(R.string.campoIntentContenido), contenidoNoticias[2])
                        startActivity(intent)
                    }
                    3-> {
                        intent.putExtra(getString(R.string.campoIntentTitulo),tituloNoticias[3])
                        intent.putExtra(getString(R.string.campoIntentContenido), contenidoNoticias[3])
                        startActivity(intent)
                    }
                }
            }
        }
    }

    private inner class AdaptadorPersonalizado(
        context: Context,
        resource: Int,
        objects: Array<String>
    ) : ArrayAdapter<String>(context, resource, objects) {

        override fun getDropDownView(
            position: Int,
            convertView: View?,
            parent: ViewGroup
        ): View {
            return crearFilaPersonalizada(position, convertView, parent)
        }

        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup
        ): View {
            return crearFilaPersonalizada(position, convertView, parent)
        }

        private fun crearFilaPersonalizada(
            position: Int,
            convertView: View?,
            parent: ViewGroup
        ): View{
            val layoutInflater = LayoutInflater.from(context)
            val rowView = convertView ?: layoutInflater.inflate(R.layout.lineaspiner, parent, false)

            rowView.findViewById<TextView>(R.id.Titulonoticia).text = categorias[position]

            rowView.findViewById<ImageView>(R.id.iconoNoticia).setImageResource(images[position])


            return rowView
        }

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

}
