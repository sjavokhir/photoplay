package uz.javokhirdev.photoplay.cast.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.javokhirdev.photoplay.cast.domain.usecase.CastUseCases
import uz.javokhirdev.photoplay.core.util.Extras
import javax.inject.Inject

@HiltViewModel
class CastViewModel @Inject constructor(
    private val castUseCases: CastUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val uiState = MutableStateFlow(CastState())

    private val actorId = savedStateHandle.get<Int>(Extras.CAST_ID_KEY)

    init {
        getActor()
        getMovies()
    }

    private fun getActor() {
        actorId ?: return

        viewModelScope.launch {
            castUseCases.getActor(actorId)
                .onSuccess {
                    uiState.value = uiState.value.copy(
                        actor = it
                    )
                }
        }
    }

    private fun getMovies() {
        viewModelScope.launch {
            castUseCases.getKnownFor()
                .onSuccess {
                    uiState.value = uiState.value.copy(
                        movies = it
                    )
                }
        }
    }
}