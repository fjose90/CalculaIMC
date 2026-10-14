package dev.fernandojose.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.fernandojose.ui.R
import dev.fernandojose.model.ImcCalculadora

class MainActivity : AppCompatActivity() {

    private lateinit var editPeso: EditText
    private lateinit var editAltura: EditText
    private lateinit var btnCalcular: Button
    private lateinit var btnLimpar: Button
    private lateinit var textResultado: TextView

    private val calculadora = ImcCalculadora()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializarComponentes()
        configurarCliques()
    }

    private fun inicializarComponentes() {
        editPeso = findViewById(R.id.etPeso)
        editAltura = findViewById(R.id.etAltura)
        btnCalcular = findViewById(R.id.btCalcular)
        btnLimpar = findViewById(R.id.btLimpar)
        textResultado = findViewById(R.id.tvResultado)
    }

    private fun configurarCliques() {
        btnCalcular.setOnClickListener {
            val pesoStr = editPeso.text.toString().replace(",", ".")
            val alturaStr = editAltura.text.toString().replace(",", ".")

            val peso = pesoStr.toDoubleOrNull()
            val altura = alturaStr.toDoubleOrNull()

            if (peso != null && altura != null) {
                try {
                    val resultado = calculadora.calcular(peso, altura)
                    textResultado.text =
                        String.format("IMC: %.2f\n%s", resultado.first, resultado.second)
                } catch (e: IllegalArgumentException) {
                    Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Preencha os campos corretamente!", Toast.LENGTH_SHORT).show()
            }
        }

        btnLimpar.setOnClickListener {
            editPeso.text.clear()
            editAltura.text.clear()
            textResultado.text = "0.0"
            editPeso.requestFocus()
        }
    }
}