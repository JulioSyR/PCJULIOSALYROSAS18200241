package com.example.pregunta1juliosalyrosas

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Equipo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_equipo)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Lista de equipos de fútbol
        val equipos = listOf(
            "Real Madrid",
            "Barcelona",
            "Manchester United",
            "Bayern Munich",
            "Paris Saint-Germain",
            "Juventus",
            "Liverpool",
            "Manchester City",
            "Chelsea",
            "Tottenham Hotspur"
        )

        // Configurar el ListView
        val listViewEquipos = findViewById<ListView>(R.id.listview_equipos)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, equipos)
        listViewEquipos.adapter = adapter

        // Configurar el botón para regresar al login
        val btnRegresar = findViewById<Button>(R.id.btn_regresar_login_equipo)
        btnRegresar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
