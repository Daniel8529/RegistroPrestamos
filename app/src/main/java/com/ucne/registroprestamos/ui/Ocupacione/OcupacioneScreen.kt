package com.ucne.registroprestamos.ui.Ocupacione

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ucne.registroprestamos.model.Ocupacione

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OcupacioneScreen(
    onNavigateBack: () -> Unit,
    viewModel: OcupacionesViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Ocupacione") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.Save()
                onNavigateBack()
            }) {
                Icon(imageVector = Icons.Default.Create, contentDescription = "Add a Ocupacione")
            }
        }
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
                onValueChange = { viewModel.Sueldo= it })
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(8.dp)
            ) {

                Button(modifier = Modifier.fillMaxWidth(),onClick = {
                    viewModel.Save()
                    onNavigateBack()

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