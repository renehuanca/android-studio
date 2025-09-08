package com.example.ejercicio_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejercicio_3.ui.theme.Ejercicio3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio3Theme {
                Scaffold { innerPadding -> // Scaffold proporciona padding para el contenido
                    // Usar Column para apilar los elementos verticalmente
                    Column(
                        modifier = Modifier
                            .padding(innerPadding) // Aplicar el padding del Scaffold
                            .fillMaxSize(), // Opcional: para que la columna llene la pantalla
                        horizontalAlignment = Alignment.CenterHorizontally // Opcional: si quieres centrar todo el contenido
                    ) {
                        HeaderSection()
                        ServicesSection()

                    }
                }
            }
        }
    }
}


@Composable
fun HeaderSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF003366))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Universidad Mayor de San Andrés",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "CENSO",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF003366)
        )
        Text(
            text = "UNIVERSITARIO UMSA 2025",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun ServicesSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ServiceItem("Oferta Académica", Icons.Default.Settings)
            ServiceItem("Servicios Virtuales", Icons.Default.Home)
            ServiceItem("Medios de Comunicación", Icons.Default.Star)
            ServiceItem("Interacción Social", Icons.Default.Info)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Icon(Icons.Default.Home, contentDescription = null)
            Icon(Icons.Default.Info, contentDescription = null)
            Icon(Icons.Default.Settings, contentDescription = null)
            Icon(Icons.Default.Star, contentDescription = null)
        }
    }
}

@Composable
fun ServiceItem(title: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable() { }
    ) {
        Icon(icon, contentDescription = title, tint = Color(0xFF003366))
        Text(text = title, fontSize = 12.sp)
    }
}