package com.ucne.registroprestamos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.ui.Modifier

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ucne.registroprestamos.ui.OcupacioneL_list.OcupacioneListScreen
import com.ucne.registroprestamos.ui.theme.RegistroPrestamosTheme
import com.ucne.registroprestamos.ui.Ocupacione.OcupacioneScreen
import com.ucne.registroprestamos.ui.Persona.PersonaScreen
import com.ucne.registroprestamos.ui.Prestamo.PrestamoScreen
import com.ucne.registroprestamos.ui.Persona_list.PersonaListScreen
import com.ucne.registroprestamos.ui.Prestamo_list.PrestamoListScreen



import com.ucne.registroprestamos.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegistroPrestamosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.Menu.route
                    ) {
                        composable(Screen.Menu.route) {
                            Menu(

                                onClick = { navController.navigate(Screen.OcupacioneScreen.route) },

                                onClick2 = { navController.navigate(Screen.PersonaScreen.route) } ,

                                onClick3 = { navController.navigate(Screen.OcupacioneListScreen.route) },

                                onClick4 = { navController.navigate(Screen.PersonaListScreen.route) },
                                onClick5 = { navController.navigate(Screen.PrestamoScreen .route) },
                                onClick6 = { navController.navigate(Screen.PrestamoListScreen .route) }


                            )
                        }
                        composable(Screen.OcupacioneScreen.route) {
                            OcupacioneScreen({ navController.navigateUp() })
                        }
                        composable(Screen.PersonaScreen.route) {
                            PersonaScreen({ navController.navigateUp() })
                        }
                        composable(Screen.PrestamoScreen.route) {
                            PrestamoScreen({ navController.navigateUp() })
                        }
                        composable(Screen.OcupacioneListScreen.route) {
                            OcupacioneListScreen({ navController.navigateUp() })
                        }
                        composable(Screen.PersonaListScreen.route) {
                            PersonaListScreen({ navController.navigateUp() })
                        }

                        composable(Screen.PrestamoListScreen.route) {
                            PrestamoListScreen({ navController.navigateUp() })
                        }

                    }

                }
            }

        }
    }
}


