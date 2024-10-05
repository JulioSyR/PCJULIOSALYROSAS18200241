package com.example.pregunta1juliosalyrosas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Rendimiento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rendimiento)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtener referencias a los campos de entrada y el botón de cálculo
        val inputKilometros = findViewById<EditText>(R.id.input_kilometros)
        val inputMinutos = findViewById<EditText>(R.id.input_minutos)
        val resultRendimiento = findViewById<TextView>(R.id.result_rendimiento)
        val btnCalcularRendimiento = findViewById<Button>(R.id.btn_calcular_rendimiento)

        // Configurar el botón para calcular el rendimiento
        btnCalcularRendimiento.setOnClickListener {
            val km = inputKilometros.text.toString().toDoubleOrNull()
            val minutos = inputMinutos.text.toString().toDoubleOrNull()

            if (km != null && minutos != null && minutos > 0) {
                val rendimiento = km / minutos
                resultRendimiento.text = "Rendimiento: %.2f km/min".format(rendimiento)
            } else {
                Toast.makeText(this, "Por favor ingrese valores válidos", Toast.LENGTH_SHORT).show()
            }
        }

        // Configurar el botón para regresar al login
        val btnRegresar = findViewById<Button>(R.id.btn_regresar_login_rendimiento)
        btnRegresar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
