package com.ucne.registroprestamos

import com.ucne.registroprestamos.ui.OcupacioneL_list.OcupacioneListViewModel



import android.content.Context
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ucne.registroprestamos.model.Ocupacione
import com.ucne.registroprestamos.repository.ocupacioneRepository
import com.ucne.registroprestamos.ui.Prestamo.PrestamoScreen
import com.ucne.registroprestamos.util.Screen
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Menu(
    onClick: () -> Unit,
    onClick2: () -> Unit,
    onClick3: () -> Unit,
    onClick4: () -> Unit,
    onClick5: () -> Unit,
    onClick6: () -> Unit

) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Menu") })
        },




        ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp)
        ) {

            CenterAlignedTopAppBar(title = { Text("Agregar ocupacion") })
            Button(modifier = Modifier.fillMaxWidth(),onClick =onClick) {


                Icon(
                    imageVector = Icons.Default.AccountCircle,contentDescription = "Add a Ocupacione"
                )


            }
            CenterAlignedTopAppBar(title = { Text("Agregar Persona") })
            Button(modifier = Modifier.fillMaxWidth(),onClick =onClick2) {


                Icon(
                    imageVector = Icons.Default.AccountCircle,contentDescription = "Add a Ocupacione"
                )


            }
            CenterAlignedTopAppBar(title = { Text("Agregar Prestamo") })
            Button(modifier = Modifier.fillMaxWidth(),onClick =onClick5) {


                Icon(
                    imageVector = Icons.Default.AccountCircle,contentDescription = "Add a Ocupacione"
                )


            }
            CenterAlignedTopAppBar(title = { Text("Consultar Ocupacion") })
            Button(modifier = Modifier.fillMaxWidth(),onClick =onClick3) {


                Icon(
                    imageVector = Icons.Default.AccountCircle,contentDescription = "Add a Ocupacione"
                )


            }
            CenterAlignedTopAppBar(title = { Text("Consultar Persona") })
            Button(modifier = Modifier.fillMaxWidth(),onClick =onClick4) {


                Icon(
                    imageVector = Icons.Default.AccountCircle,contentDescription = "Add a Ocupacione"
                )


            }

            CenterAlignedTopAppBar(title = { Text("Consultar Prestamo") })
            Button(modifier = Modifier.fillMaxWidth(),onClick =onClick6) {


                Icon(
                    imageVector = Icons.Default.AccountCircle,contentDescription = "Add a Ocupacione"
                )


            }

        }





    }

}





