package com.ucne.registroprestamos.ui.Prestamo


import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.registroprestamos.model.Prestamo
import com.ucne.registroprestamos.repository.PrestamoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class PrestamoViewModel @Inject constructor (val repository: PrestamoRepository
) : ViewModel() {


    var Fecha by mutableStateOf("")
    var Vence by mutableStateOf("")
    var PersonaId by mutableStateOf("")
    var Concepto by mutableStateOf("")
    var Monto by mutableStateOf("")
    var Balance by mutableStateOf("")



    fun Save(){
        viewModelScope.launch {
            repository.insertprestamo(
                Prestamo(
                    Fecha=Fecha ,
                    Vence=Vence,
                    PersonaId=PersonaId.toInt(),
                    Concepto=Concepto,
                    Monto=Monto.toDouble(),
                    Balance=Balance.toDouble()
                )
            )
        }
    }
    fun editar(){
        viewModelScope.launch {
            repository.updateprestamo(
                Prestamo(
                    Fecha=Fecha ,
                    Vence=Vence,
                    PersonaId=PersonaId.toInt(),
                    Concepto=Concepto,
                    Monto=Monto.toDouble(),
                    Balance=Balance.toDouble()
                )
            )
        }
    }
    fun Elmininar(){
        viewModelScope.launch {
            repository.deleteprestamo(
                Prestamo(
                    Fecha=Fecha ,
                    Vence=Vence,
                    PersonaId=PersonaId.toInt(),
                    Concepto=Concepto,
                    Monto=Monto.toDouble(),
                    Balance=Balance.toDouble()
                )
            )
        }
    }
}