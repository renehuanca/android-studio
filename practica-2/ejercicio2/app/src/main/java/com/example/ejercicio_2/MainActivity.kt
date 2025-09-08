package com.example.ejercicio_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejercicio_2.ui.theme.Ejercicio2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio2Theme {
                Scaffold { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding) // Aplicar el padding del Scaffold
                            .fillMaxSize(), // Opcional: para que la columna llene la pantalla
                        horizontalAlignment = Alignment.CenterHorizontally // Opcional: si quieres centrar todo el contenido
                    ) {
                        WhatsAppHeader()
                        SearchBar()
                        CategoryBadges()
                        ChatList()
                    }
                }
            }
        }
    }
}
@Composable
fun WhatsAppHeader() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "WhatsApp",
            color = Color(0xFF25D366),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Row {
            Icon(Icons.Default.Search, contentDescription = "Buscar")
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.Default.MoreVert, contentDescription = "Menú")
        }
    }
}

@Composable
fun SearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        placeholder = { Text("Buscar o empezar un chat nuevo") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(50)
    )
}

@Composable
fun CategoryBadges() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        listOf("Todos", "No leídos", "Favoritos", "Grupos").forEach {
            Surface (
                shape = RoundedCornerShape(50),
                color = Color(0xFFDCF8C6),
                modifier = Modifier.padding(4.dp)
            ) {
                Text(
                    text = it,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun ChatList() {
    Column {
        ChatItem("Umsawilmaprefas@", "12:30")
        ChatItem("Docentes Informatica UMSA", "Ayer")
    }
}

@Composable
fun ChatItem(name: String, time: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = name, fontWeight = FontWeight.SemiBold)
        Text(text = time, color = Color.Gray, fontSize = 12.sp)
    }
}