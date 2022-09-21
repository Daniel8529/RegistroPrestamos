package com.ucne.registroprestamos.ui.Persona

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.registroprestamos.model.Persona
import com.ucne.registroprestamos.repository.PersonaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class PersonaViewModel @Inject constructor (val repository: PersonaRepository
) : ViewModel() {

    var Nombre by mutableStateOf("")
    var Telefono by mutableStateOf("")
    var Celular by mutableStateOf("")
    var Email by mutableStateOf("")
    var Direccion by mutableStateOf("")
    var FechaNacimiento by mutableStateOf("")
    var OcupacionId by mutableStateOf("")
    var Balance by mutableStateOf("")



    fun Save(){
        viewModelScope.launch {
            repository.insertpersona(
                Persona(
                    Nombre=Nombre,
                    Telefono=Telefono.toInt(),
                    Celular=Celular.toInt(),
                    Email=Email ,
                    Direccion=Direccion,
                    FechaNacimiento=FechaNacimiento,
                    OcupacionId=OcupacionId ,
                    Balance=Balance.toDouble()
                )
            )
        }
    }
}