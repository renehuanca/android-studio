package com.example.ejercicicio3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etCI: EditText
    private lateinit var btnIrAOtraPantalla: Button
    private lateinit var btnExit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etName = findViewById<EditText>(R.id.etName)
        etCI = findViewById<EditText>(R.id.etCI)
        btnIrAOtraPantalla = findViewById<Button>(R.id.btnIrAOtraPantalla)
        btnExit = findViewById<Button>(R.id.btnExit)

        btnIrAOtraPantalla.setOnClickListener {
            val name = etName.text.toString().trim()
            val ci = etCI.text.toString().trim()
            var isValid = true

            if (name.isEmpty()) {
                etName.error = "Por favor ingrese su nombre"
                isValid = false
            }

            if (ci.isEmpty()) {
                etCI.error = "Por favor ingrese su carnet"
                isValid = false
            }

            if (isValid) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("ci", ci)
                startActivity(intent)
            }
        }

        btnExit.setOnClickListener {
            finish()
        }
    }
}