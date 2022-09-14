package com.ucne.registroprestamos.ui.Ocupacione

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ucne.registroprestamos.model.Ocupacione
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.KeyboardType


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OcupacioneScreen(
    onNavigateBack: () -> Unit,
    viewModel: OcupacionesViewModel = hiltViewModel()
) {
    var descripcionValidar by remember { mutableStateOf(false) }
    var valorValidar by remember { mutableStateOf(false) }
    val context = LocalContext.current
     fun validar()
     {
         if(viewModel.Descripcion.isBlank()||viewModel.Sueldo.isBlank() ){
             if(viewModel.Descripcion.isBlank())
             {Toast.makeText(context, "La descricion esta vacia", Toast.LENGTH_SHORT).show()}
             if(viewModel.Sueldo.isBlank() )
             {Toast.makeText(context, "La sueldo esta vacia", Toast.LENGTH_SHORT).show()}


         }else{

                 viewModel.Save()
                 onNavigateBack()

         }


     }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Ocupacione") })
        },

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp)
        ) {

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Descripcion") },
                value = viewModel.Descripcion,
                onValueChange = { viewModel.Descripcion = it })

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Sueldo") },
                value = viewModel.Sueldo,
                onValueChange = { viewModel.Sueldo= it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(8.dp)
            ) {

                Button(modifier = Modifier.fillMaxWidth(),onClick = {

                    validar()



                }) {

                    Icon(
                        imageVector = Icons.Default.AccountCircle,contentDescription = "Add a Ocupacione"
                    )

                }
            }


        }
    }

}


@Composable
@Preview(showSystemUi = true)
fun Preview() {

    OcupacioneScreen({ })

}