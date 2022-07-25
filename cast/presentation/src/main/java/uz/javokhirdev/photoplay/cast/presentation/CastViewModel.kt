package uz.javokhirdev.photoplay.cast.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.javokhirdev.photoplay.cast.domain.usecase.CastUseCases
import javax.inject.Inject

@HiltViewModel
class CastViewModel @Inject constructor(
    private val castUseCases: CastUseCases
) : ViewModel() {

    val uiState = MutableStateFlow(CastState())

    init {
        getMovies()
    }

    fun getActor(actorId: Int? = null) {
        actorId ?: return

        viewModelScope.launch {
            castUseCases.getActor.invoke(actorId)
                .onSuccess {
                    uiState.value = uiState.value.copy(
                        actor = it
                    )
                }
        }
    }

    private fun getMovies() {
        viewModelScope.launch {
            castUseCases.getKnownFor.invoke()
                .onSuccess {
                    uiState.value = uiState.value.copy(
                        movies = it
                    )
                }
        }
    }
}