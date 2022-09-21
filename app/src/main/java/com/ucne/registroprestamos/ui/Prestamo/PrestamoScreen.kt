package com.ucne.registroprestamos.ui.Prestamo

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
import com.ucne.registroprestamos.model.Prestamo
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.KeyboardType
import com.ucne.registroprestamos.ui.Ocupacione.OcupacionesViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrestamoScreen(
    onNavigateBack: () -> Unit,
    viewModel: PrestamoViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    var Fechavallida by remember {mutableStateOf(false)}
    var Vencevallida by remember {mutableStateOf(false)}
    var PersonaIdvallida by remember {mutableStateOf(false)}
    var Conceptovallida by remember {mutableStateOf(false)}
    var Montovallida by remember {mutableStateOf(false)}
    var Balancevallida by  remember {mutableStateOf(false)}
    fun validar()
    {
        if(viewModel.Fecha.isBlank()||viewModel.Vence.isBlank()||viewModel.PersonaId.isBlank()||viewModel.Concepto.isBlank()
            ||viewModel.Monto.isBlank()||viewModel.Balance.isBlank()){

              Fechavallida=viewModel.Fecha.isBlank()
              Vencevallida=viewModel.Vence.isBlank()
              PersonaIdvallida = viewModel.PersonaId.isBlank()
              Conceptovallida=viewModel.Concepto.isBlank()
              Montovallida=viewModel.Monto.isBlank()
              Balancevallida=viewModel.Balance.isBlank()



        }else{

            viewModel.Save()
            onNavigateBack()

        }


    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Prestamo") })
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
                label = { Text(text = "Fecha") },
                value = viewModel.Fecha,
                onValueChange = { viewModel.Fecha = it
                    Fechavallida=false},
                isError =Fechavallida)
            if (Fechavallida) {
                Text(
                    text = "La Fecha esta vacia",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(start = 16.dp)


                )
            }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Vence") },
                value = viewModel.Vence,
                onValueChange = { viewModel.Vence= it
                    Vencevallida=false},
             isError =Vencevallida)
            if (Vencevallida) {
                Text(
                    text = "El Vence esta vacio",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(start = 16.dp)


                )
            }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Persona") },
                value = viewModel.PersonaId,
                onValueChange = { viewModel.PersonaId= it
                    PersonaIdvallida=false},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                isError =PersonaIdvallida)
            if (PersonaIdvallida) {
                Text(
                    text = "La persona esta vacio",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(start = 16.dp)


                )
            }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Concepto") },
                value = viewModel.Concepto,
                onValueChange = { viewModel.Concepto= it
                    Conceptovallida=false},
                isError =Conceptovallida)
            if (Conceptovallida) {
                Text(
                    text = "El concepto esta vacio",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(start = 16.dp)


                )
            }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Monto") },
                value = viewModel.Monto,
                onValueChange = { viewModel.Monto= it
                    Montovallida=false},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                isError =Montovallida)
            if (Montovallida) {
                Text(
                    text = "El monto esta vacio",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(start = 16.dp)


                )
            }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Balance") },
                value = viewModel.Balance,
                onValueChange = { viewModel.Balance= it
                    Balancevallida=false},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                isError =Balancevallida)
            if (Balancevallida) {
                Text(
                    text = "La sueldo es vacia",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(start = 16.dp)


                )
            }


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

    PrestamoScreen({ })

}