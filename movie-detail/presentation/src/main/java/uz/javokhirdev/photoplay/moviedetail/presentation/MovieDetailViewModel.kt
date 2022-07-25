package uz.javokhirdev.photoplay.moviedetail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.javokhirdev.photoplay.moviedetail.domain.usecase.MovieDetailUseCases
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetailUseCases: MovieDetailUseCases
) : ViewModel() {

    val uiState = MutableStateFlow(MovieDetailState())

    init {
        getActors()
    }

    fun handleEvent(event: MovieDetailEvent) {
        when (event) {
            MovieDetailEvent.OnWatchClick -> {}
            MovieDetailEvent.OnCastClick -> {}
        }
    }

    fun getMovie(movieId: Int? = null) {
        movieId ?: return

        viewModelScope.launch {
            movieDetailUseCases.getMovie.invoke(movieId)
                .onSuccess {
                    uiState.value = uiState.value.copy(
                        movie = it
                    )

                    getActors()
                }
        }
    }

    private fun getActors() {
        viewModelScope.launch {
            movieDetailUseCases.getActors.invoke()
                .onSuccess {
                    uiState.value = uiState.value.copy(
                        actors = it
                    )
                }
        }
    }
}