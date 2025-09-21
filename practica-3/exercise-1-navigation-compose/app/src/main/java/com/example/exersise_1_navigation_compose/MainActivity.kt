package com.example.exersise_1_navigation_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MisActividades()
        }
    }
}

@Composable
fun MisActividades() {
    val navController = rememberNavController() // Controlador de navegación

    NavHost(
        navController = navController, // Pasamos el controlador
        startDestination = "menu" // Pantalla inicial
    ) {
        composable("menu") { Menu(navController) } // Primera pantalla
        composable("loginPersonas") { LoginPersonas(navController) } // Segunda pantalla
        composable("loginEmpresas") { LoginEmpresas(navController) } // Tercera pantalla
    }
}

@Composable
fun Menu(navController: NavHostController) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .background(Color(0xFF28A745))
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column (
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.weight(1f)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Carrito",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Solicita tus\nproductos en línea",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = "Video Banca",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Video Banca",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navController.navigate("loginPersonas") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7E57C2)), // morado
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Acceso a Banca Personas", color = Color.White)
            }

            Button(
                onClick = { navController.navigate("loginEmpresas") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E35B1)), // morado oscuro
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Acceso a Banca Empresas", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true) // Añade showBackground para ver mejor
@Composable
fun MenuPreview() {
    Menu(rememberNavController())
}

// Segunda pantalla con botones para avanzar y retroceder
@Composable
fun LoginPersonas(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bienvenido",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A237E)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Ingresa al Portal de Banca Personas del BNB",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            placeholder = { Text("Nombre de usuario") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { isChecked = !isChecked }) {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Checkbox",
                    tint = Color.Black
                )
            }
            Text("No soy un robot", fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* TODO acción login */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF28A745)) // Verde
        ) {
            Text("Validar", color = Color.White)
        }
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF28A745)) // Verde
        ) {
            Text("VOLVER", color = Color.White)
        }
    }
}
// Tercera pantalla con botón para volver a la segunda
@Composable
fun LoginEmpresas(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black) // Fondo negro
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título
            Text(
                text = "Bienvenido",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Ingresa al Portal de Banca Personas del BNB",
                fontSize = 14.sp,
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de texto usuario
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                placeholder = { Text("Nombre de usuario", color = Color.Gray) },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = null, tint = Color.White) },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.Gray,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))


            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { isChecked = !isChecked }) {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = "Checkbox",
                        tint = Color.White
                    )
                }
                Text("No soy un robot", fontSize = 14.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* TODO acción login */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF28A745)) // Verde
            ) {
                Text("Validar", color = Color.White)
            }
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF28A745)) // Verde
            ) {
                Text("VOLVER", color = Color.White)
            }
        }
    }
}
