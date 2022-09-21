package com.ucne.registroprestamos.ui.Ocupacione
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.registroprestamos.model.Ocupacione
import com.ucne.registroprestamos.repository.ocupacioneRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class OcupacionesViewModel @Inject constructor (val repository: ocupacioneRepository
) : ViewModel() {

    var Descripcion by mutableStateOf("")
    var Sueldo by mutableStateOf("")



    fun Save(){
        viewModelScope.launch {
            repository.inser(
                Ocupacione(
                    Descripcion = Descripcion,

                    Sueldo = Sueldo.toFloat()

                )
            )
        }
    }
}