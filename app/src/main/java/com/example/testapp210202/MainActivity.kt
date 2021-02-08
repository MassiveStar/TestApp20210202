package com.example.testapp210202

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testapp210202.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.resultado.observe(this, Observer { binding.resultadoText.text = it.toString() })

        binding.sumaButton.setOnClickListener {
            if (validacionDatos()) {
                viewModel.calcularResultado(
                        binding.dato1Edit.text.toString().toDouble(),
                        binding.dato2Edit.text.toString().toDouble(),
                        "suma")
            } else
                Toast.makeText(this, "Ingrese datos validos", Toast.LENGTH_SHORT).show()
        }

        binding.restaButton.setOnClickListener {
            if (validacionDatos()) {
                viewModel.calcularResultado(
                        binding.dato1Edit.text.toString().toDouble(),
                        binding.dato2Edit.text.toString().toDouble(),
                        "resta")
            } else
                Toast.makeText(this, "Ingrese datos validos", Toast.LENGTH_SHORT).show()
        }
        binding.multiplicacionButton.setOnClickListener {
            if (validacionDatos()) {
                viewModel.calcularResultado(
                        binding.dato1Edit.text.toString().toDouble(),
                        binding.dato2Edit.text.toString().toDouble(),
                        "multiplicacion")
            } else
                Toast.makeText(this, "Ingrese datos validos", Toast.LENGTH_SHORT).show()
        }
        binding.divisionButton.setOnClickListener {
            if (validacionDatos()) {
                if (validacionDivCero(binding.dato2Edit.text.toString().toDouble())) {
                    viewModel.calcularResultado(
                            binding.dato1Edit.text.toString().toDouble(),
                            binding.dato2Edit.text.toString().toDouble(),
                            "division")
                } else
                    Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show()
            } else
                Toast.makeText(this, "Ingrese datos validos", Toast.LENGTH_SHORT).show()
        }
        binding.limpiarButton.setOnClickListener {
            binding.apply {
                dato1Edit.text.clear()
                dato2Edit.text.clear()
                resultadoText.text = ""
            }
        }

    }

    private fun validacionDatos(): Boolean {
        return binding.dato1Edit.text.toString().toDoubleOrNull() != null &&
                binding.dato2Edit.text.toString().toDoubleOrNull() != null
    }

    private fun validacionDivCero(dividendo: Double): Boolean {
        return dividendo != 0.0
    }
}