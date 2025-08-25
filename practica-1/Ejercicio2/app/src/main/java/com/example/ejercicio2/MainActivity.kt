package com.example.ejercicio2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.security.MessageDigest
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var etCi: EditText
    private lateinit var etHashCode: EditText
    private lateinit var btnProcess: Button
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

        etCi = findViewById(R.id.etCi)
        etHashCode = findViewById(R.id.etHashCode)
        btnProcess = findViewById(R.id.btnProcess)
        btnExit = findViewById(R.id.btnExit)

        btnProcess.setOnClickListener {
            val ci = etCi.text.toString().trim()

            if (ci.isNotBlank()) {
                val generatedCode = generateHashCode(ci)

                etHashCode.setText(generatedCode)

            } else {
                etCi.error = "El CI no puede estar vacío"
                etHashCode.setText("")
            }
        }

        btnExit.setOnClickListener {
            finish()
        }
    }

    private fun generateHashCode(texto: String): String {
        val md = MessageDigest.getInstance("SHA-256")
        val bytes = md.digest(texto.toByteArray(Charsets.UTF_8))
        return bytes.joinToString("") { "%02x".format(it) }
    }
}