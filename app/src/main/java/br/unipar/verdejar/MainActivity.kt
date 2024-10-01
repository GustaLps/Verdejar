package com.empresa.verdejar

import Planta
import PlantaAdapter
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.unipar.verdejar.R

class MainActivity : AppCompatActivity() {

    private val plantas = mutableListOf<Planta>()
    private lateinit var plantaAdapter: PlantaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinnerCuidado)
        val options = arrayOf("Baixo", "Médio", "Alto")
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)

        plantaAdapter = PlantaAdapter(plantas, this)
        findViewById<ListView>(R.id.listViewPlantas).adapter = plantaAdapter

        findViewById<Button>(R.id.buttonAdicionar).setOnClickListener {
            addPlanta()
        }
    }

    private fun addPlanta() {
        val nome = findViewById<EditText>(R.id.editTextNomePlanta).text.toString()
        val dataPlantio = findViewById<EditText>(R.id.editTextDataPlantio).text.toString()
        val nivelCuidado = findViewById<Spinner>(R.id.spinnerCuidado).selectedItem.toString()
        val quantidadeAgua = findViewById<EditText>(R.id.editTextQuantidadeAgua).text.toString().toIntOrNull() ?: 0

        if (nome.isNotEmpty() && dataPlantio.isNotEmpty()) {
            val planta = Planta(nome, dataPlantio, nivelCuidado, quantidadeAgua)
            plantas.add(planta)
            plantaAdapter.notifyDataSetChanged()
            updateTotalPlantas()
            clearFields()
        }
    }

    private fun updateTotalPlantas() {
        findViewById<TextView>(R.id.textViewTotalPlantas).text = "Total de Plantas: ${plantas.size}"
    }

    private fun clearFields() {
        findViewById<EditText>(R.id.editTextNomePlanta).text.clear()
        findViewById<EditText>(R.id.editTextDataPlantio).text.clear()
        findViewById<EditText>(R.id.editTextQuantidadeAgua).text.clear()
        findViewById<Spinner>(R.id.spinnerCuidado).setSelection(0)
    }
}
