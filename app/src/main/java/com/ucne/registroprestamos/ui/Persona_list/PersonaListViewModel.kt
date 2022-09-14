package com.ucne.registroprestamos.ui.Persona_list



import android.content.Context
import android.speech.tts.TextToSpeech
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ucne.registroprestamos.model.Persona
import com.ucne.registroprestamos.repository.PersonaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PersonalListUiState(
    val persona: List<Persona> = emptyList(),
    val texto: String = "Meeting"
)

@HiltViewModel
class PersonaListViewModel @Inject constructor(
    val repository: PersonaRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(PersonalListUiState())
    val uiState: StateFlow<PersonalListUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllPersona().collect() { list ->
                _uiState.getAndUpdate {
                    it.copy( persona = list )
                }
            }
        }
    }
}
