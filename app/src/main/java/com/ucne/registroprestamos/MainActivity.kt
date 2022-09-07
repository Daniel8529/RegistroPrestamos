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
                        startDestination = Screen.OcupacioneListScreen.route
                    ) {
                        composable(Screen.OcupacioneListScreen.route) {
                            OcupacioneListScreen(

                                onClick = { navController.navigate(Screen.OcupacioneScreen.route) }
                            )
                        }
                        composable(Screen.OcupacioneScreen.route) {
                            OcupacioneScreen({ navController.navigateUp() })
                        }
                    }

                }
            }

        }
    }
}

