package com.example.ejercicio_2_navigation_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.autofill.contentType
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ejercicio_2_navigation_compose.ui.theme.Ejercicio2navigationcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio2navigationcomposeTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("home") {
                            HomeScreen(navController)
                        }

                        composable("preuniversitarioScreen") {
                            CourseScreen(
                                title = "Curso Preuniversitario",
                                description = " ",
                                imageResId = R.drawable.preuniversitario,
                                navController
                            )
                        }

                        composable("licenciaturaScreen") {
                            CourseScreen(
                                title = "Programas de Licenciatura",
                                description = "Actualmente la facultad de ciencias puras tiene los mejores docentese , y ofrece programas de licenciatura com son: matematica, informatica, fisica, quimica entre otros claro hay otros mas pero no me acuerdo.",
                                imageResId = R.drawable.licenciatura,
                                navController
                            )
                        }

                        composable("maestriaScreen") {
                            CourseScreen(
                                title = "Programas de Maestría",
                                description = "Em maestrias actualmente la facultad de ciencias puras tiene los mejores docentese , y ofrece programas de licenciatura com son: matematica, informatica, fisica, quimica entre otros claro hay otros mas pero no me acuerdo.",
                                imageResId = R.drawable.maestria,
                                navController
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Card(
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "PROGRAMA",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )


                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Ciencia y tecnologia de la energia",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Este programa es el unico espacio que genera este texto deberia de generarlo con ia pero como estoy un poco estresado lo escribo a mano bueno a mano pero con el teclado xd.",
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            EducationCard(
                title = "PREUNIVERSITARIO",
                description = "Cursos preuniversitarios tiene el objetivo de nivelar al estudiante para la prueba de suficiencia academica",
                Color.Red,
                modifier = Modifier.weight(1f)
            ) {
                navController.navigate("preuniversitarioScreen")
            }
            EducationCard(
                title = "LICENCIATURA",
                "Curso Licenciatura tiene como objetivo, nivelar y reforzar los conocimientos necesarios en áreas que exige la carrera de interés, existen dos etapas para tomar estos cursos: Prueba de",
                Color.Green,
                modifier = Modifier.weight(1f)
            ) {
                navController.navigate("licenciaturaScreen")
            }
            EducationCard(
                title = "MAESTRIA",
                "Curso Maestria tiene como objetivo, nivelar y reforzar los conocimientos necesarios en áreas que exige la carrera de interés, existen dos etapas para tomar estos cursos: Prueba de",
                Color.Yellow,
                modifier = Modifier.weight(1f)
            ) {
                navController.navigate("maestriaScreen")
            }
        }
    }

}

@Composable
fun CourseScreen(
    title: String,
    description: String,
    @DrawableRes imageResId: Int,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )


        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = description,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface,
            lineHeight = 18.sp
        )


        Image(
            painter = painterResource(imageResId),
            contentDescription = "Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Button (
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF28A745)) // Verde
        ) {
            Text("VOLVER", color = Color.White)
        }
    }
}


@Composable
fun EducationCard(
    title: String,
    description: String,
    color: Color,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier.clickable { onClick() },
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.size(50.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = title,
                    tint = color,
                    modifier = Modifier.size(30.dp)
                )
            }

            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = description,
                fontSize = 14.sp,
                lineHeight = 18.sp,
            )
        }
    }
}

