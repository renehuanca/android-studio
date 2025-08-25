package com.example.ejercicioenclases

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etCi: EditText
    private lateinit var etNombre: EditText
    private lateinit var etApellido: EditText
    private lateinit var btnProcesar: Button
    private lateinit var btnSalir: Button
    private lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etCi = findViewById(R.id.etCi)
        etNombre = findViewById(R.id.etNombre)
        etApellido = findViewById(R.id.etApellido)
        btnProcesar = findViewById(R.id.btnProcesar)
        btnSalir = findViewById(R.id.btnSalir)
        resultado = findViewById(R.id.resultado)

        btnProcesar.setOnClickListener {
            val ci = etCi.text.toString()
            var nombre = etNombre.text.toString()
            var apellido = etApellido.text.toString()

            nombre = nombre.toTitleCase()
            apellido = apellido.toTitleCase()

            val ciNumero = ci.substring(0, ci.length - 2).toIntOrNull()
            val extension = ci.substring(ci.length - 2)
            val nombreCompleto = "$nombre $apellido"

            resultado.text = "CI: $ciNumero\nNombre Completo: $nombreCompleto\nExtensión: $extension"
        }

        btnSalir.setOnClickListener {
            finish()
        }
    }

    fun String.toTitleCase(): String {
        if (this.isBlank()) return "" // isBlank() verifica vacío y solo espacios
        return this.trim().split(" ").joinToString(" ") { word ->
            if (word.isEmpty()) "" // Manejar múltiples espacios que resultan en palabras vacías
            else word.lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
        }
    }
}