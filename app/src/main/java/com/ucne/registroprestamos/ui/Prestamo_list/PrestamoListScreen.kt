package com.ucne.registroprestamos.ui.Prestamo_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ucne.registroprestamos.model.Prestamo
import com.ucne.registroprestamos.ui.Persona_list.PersonaListViewModel
import com.ucne.registroprestamos.ui.Prestamo.PrestamoViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun PrestamoListScreen(
    onClick: () -> Unit,
    viewModel: PrestamoListViewModel = hiltViewModel() ,
    viewMode: PrestamoViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Lista de Prestamos ") })
        },


        ) {

        val uiState by viewModel.uiState.collectAsState()

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(it)) {

            PrestamoList(viewMode, onClick,
                prestamo = uiState.prestamo,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)

            )

        }

    }

}



@Composable
fun PrestamoList(viewMode: PrestamoViewModel = hiltViewModel(), onClick: () -> Unit,
    prestamo: List<Prestamo>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(prestamo) {prestamo ->
            PrestamoListRow(prestamo,viewMode, onClick)
        }
    }
}

@Composable
fun PrestamoListRow(prestamo: Prestamo,viewMode: PrestamoViewModel = hiltViewModel(), onClick: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(
            text =prestamo.Fecha,
            style = MaterialTheme.typography.titleLarge
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Fecha: ${prestamo.Fecha}"
            )

        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Vence: ${prestamo.Vence}"
            )

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Persona: ${prestamo.PersonaId}"
            )

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Concepto: ${prestamo.Concepto}"
            )

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Monto: ${prestamo.Monto}"
            )

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Balance: ${prestamo.Balance}"
            )

        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            color = Color.LightGray
        )
        Button(modifier = Modifier.fillMaxWidth(),onClick = {

            viewMode.Elmininar()




        }) {

            Icon(
                imageVector = Icons.Default.Delete,contentDescription = "Add a Ocupacione"
            )

        }
    }

}



