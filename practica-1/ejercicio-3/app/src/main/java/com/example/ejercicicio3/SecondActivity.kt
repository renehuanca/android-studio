package com.example.ejercicicio3

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tvCarnetInvertido = findViewById<TextView>(R.id.tvCarnetInvertido)
        val tvNombreIntercambiado = findViewById<TextView>(R.id.tvNombreIntercambiado)

        val name = intent.getStringE    xtra("name") ?: ""
        val ci = intent.getStringExtra("ci")
        val carnetInvertido = ci?.reversed()

        val nombreIntercambiado = if (name.length > 1) {
            name.last() + name.substring(1, name.length - 1) + name.first()
        } else name

        tvCarnetInvertido.text = carnetInvertido
        tvNombreIntercambiado.text = nombreIntercambiado

    }
}