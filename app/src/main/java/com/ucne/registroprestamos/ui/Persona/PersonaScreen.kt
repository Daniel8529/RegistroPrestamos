package com.ucne.registroprestamos.ui.Persona

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
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
import androidx.compose.material.DropdownMenuItem
@OptIn(ExperimentalMaterial3Api::class)



@Composable
fun PersonaScreen(
    onNavigateBack: () -> Unit, viewModel: PersonaViewModel = hiltViewModel()
) {
    var ocupacionselected by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var descripcionValidar by remember { mutableStateOf(false) }
    var valorValidar by remember { mutableStateOf(false) }
    val context = LocalContext.current
    fun validar()
    {
        if(viewModel.Nombre.isBlank()||viewModel.Telefono.isBlank()||viewModel.Celular.isBlank()||viewModel.Email.isBlank()
            || viewModel.Direccion.isBlank()|| viewModel.FechaNacimiento.isBlank()|| viewModel.OcupacionId.isBlank()|| viewModel.Balance.isBlank()){
           var mensaje: String=""
           if(viewModel.Nombre.isBlank())
           {
               mensaje+="El Nombre esta vacio,"
           }
            if(viewModel.Telefono.isBlank())
            {
                mensaje+="El numero Telefono esta vacio,"
            }
            if(viewModel.Celular.isBlank())
            {
                mensaje+="El numero Celular esta vacio,"
            }
            if(viewModel.Email.isBlank())
            {
                mensaje+="El Email esta vacio,"
            }
            if(viewModel.Direccion.isBlank())
            {
                mensaje+="La Direccion esta vacia,"
            }
            if(viewModel.FechaNacimiento.isBlank())
            {
                mensaje+="La fecha esta vacia,"
            }
            if(viewModel.OcupacionId.isBlank())
            {
                mensaje+="La Ocupacion esta vacia,"
            }
            if(viewModel.Balance.isBlank())
            {
                mensaje+="El balance esta vacio,"
            }
            Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()


        }else{

            viewModel.Save()
            onNavigateBack()

        }


    }
    val ocupaciones = listOf(
        Ocupacione(Id = 1, Descripcion = "Ingeniero", Sueldo =60000f),
        Ocupacione(Id = 2, Descripcion = "Ingeniero", Sueldo =50000f) ,
        Ocupacione(Id = 3, Descripcion = "Pintor",    Sueldo = 40000f),
        Ocupacione(Id = 4, Descripcion = "Maestro",   Sueldo = 60000f),
        Ocupacione(Id = 5, Descripcion = "Doctor",    Sueldo = 70000f),


//        Persona(Id = 1,Nombre="daniel",Telefono=80828382, Celular=29492,Email="jdajwa",Direccion="jdnasn",
//            FechaNacimiento="kdksa",OcupacionId=21221112),

    )
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Registro de Personas") })
        },

    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp)
        ) {

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Nombres") },
                value = viewModel.Nombre,
                onValueChange = {viewModel.Nombre= it})

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Telefono") },
                value = viewModel.Telefono,
                onValueChange = {viewModel.Telefono = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Celular") },
                value = viewModel.Celular,
                onValueChange = {viewModel.Celular= it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Email") },
                value = viewModel.Email,
                onValueChange = {viewModel.Email = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Direccion") },
                value = viewModel.Direccion,
                onValueChange = {viewModel.Direccion= it})

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Balance") },
                value = viewModel.Balance,
                onValueChange = { viewModel.Balance= it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Fecha de Nacimiento") },
                value = viewModel.FechaNacimiento,
                onValueChange = {viewModel.FechaNacimiento = it})

        Column(Modifier.padding(20.dp)) {


            OutlinedTextField(
                label = { Text(text = "Ocupaciones") },
                value = ocupacionselected,
                onValueChange = { ocupacionselected = it },
                enabled = false, readOnly = true,
                modifier = Modifier
                    .clickable { expanded = true }
                    .fillMaxWidth()
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                ocupaciones.forEach { ocupation ->
                    DropdownMenuItem(onClick = {
                        expanded = false
                        ocupacionselected = ocupation.Descripcion
                        viewModel.OcupacionId = ocupacionselected
                    }) {
                        Text(text = ocupation.Descripcion)
                    }


                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(8.dp)
            ) {

                Button(modifier = Modifier.fillMaxWidth(), onClick = {
                    validar()

                }) {

                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Add a Ocupacione"
                    )

                }
            }
        }

        }
        Spacer(modifier = Modifier)





    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview() {

    PersonaScreen({ })

}
