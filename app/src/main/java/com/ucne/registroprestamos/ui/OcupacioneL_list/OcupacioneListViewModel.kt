package com.ucne.registroprestamos.ui.OcupacioneL_list

import android.content.Context
import android.speech.tts.TextToSpeech
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.registroprestamos.model.Ocupacione
import com.ucne.registroprestamos.repository.ocupacioneRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class OcupacioneListUiState(
    val ocupaciones: List<Ocupacione> = emptyList(),
    val texto: String = "Meeting"
)

@HiltViewModel
class OcupacioneListViewModel @Inject constructor(
    val repository: ocupacioneRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(OcupacioneListUiState())
    val uiState: StateFlow<OcupacioneListUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAll().collect() { list ->
                _uiState.update {
                    it.copy( ocupaciones = list )
                }
            }
        }
    }
}
