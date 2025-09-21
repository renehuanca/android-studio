package com.example.ejercicio_1_xml


import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class EmpresasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_banca_empresas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.empresas)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnVolver = findViewById<Button?>(R.id.btnVolver)

        btnVolver.setOnClickListener(View.OnClickListener { v: View? ->
            finish() // vuelve a la anterior activity
        })

    }
}