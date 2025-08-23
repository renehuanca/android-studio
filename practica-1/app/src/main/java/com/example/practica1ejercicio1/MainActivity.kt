package com.example.practica1ejercicio1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etConsonants: EditText
    private lateinit var etVowels: EditText
    private lateinit var tvResult: TextView
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

        etName = findViewById(R.id.etName)
        etConsonants = findViewById(R.id.etConsonants)
        etVowels = findViewById(R.id.etVowels)
        tvResult = findViewById(R.id.tvResult)
        btnProcess = findViewById(R.id.btnProcess)
        btnExit = findViewById(R.id.btnExit)

        btnProcess.setOnClickListener {
            val name = etName.text.toString()

            var cVowels = 0
            var cConsonants = 0

            val vowelsFound = mutableSetOf<Char>()
            var consonantsFound = mutableSetOf<Char>()

            for (c in name) {
                if (c.isLetter()) {
                    val charLower = c.lowercaseChar()
                    if (charLower in "aeiouáéíóú") {
                        cVowels++
                        vowelsFound.add(charLower)
                    } else if (charLower in "bcdfghjklmnñpqrstvwxyz") {
                        cConsonants++
                        consonantsFound.add(charLower)
                    }
                }
            }

            etConsonants.setText(consonantsFound.joinToString(""))
            etVowels.setText(vowelsFound.joinToString(""))
            tvResult.text = "Este nombre tiene $cConsonants consonantes y $cVowels vocales."
        }

        btnExit.setOnClickListener {
            finish()
        }
    }
}