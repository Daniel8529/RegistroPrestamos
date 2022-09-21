package com.ucne.registroprestamos.ui.Prestamo_list

import android.content.Context
import android.speech.tts.TextToSpeech
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.registroprestamos.model.Prestamo
import com.ucne.registroprestamos.repository.PrestamoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PrestamoListUiState(
    val prestamo:List<Prestamo> = emptyList(),
    val texto: String = "Meeting"
)

@HiltViewModel
class PrestamoListViewModel@Inject constructor(
    val repository: PrestamoRepository
) : ViewModel() {


    private val _uiState = MutableStateFlow(PrestamoListUiState())
    val uiState: StateFlow<PrestamoListUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllPrestamo().collect() { list ->
                _uiState.getAndUpdate {
                    it.copy( prestamo = list )
                }
            }
        }
    }
}
