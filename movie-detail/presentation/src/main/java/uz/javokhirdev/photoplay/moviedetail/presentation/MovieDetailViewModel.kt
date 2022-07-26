package uz.javokhirdev.photoplay.moviedetail.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.javokhirdev.photoplay.core.util.Extras.MOVIE_ID_KEY
import uz.javokhirdev.photoplay.moviedetail.domain.usecase.MovieDetailUseCases
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetailUseCases: MovieDetailUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val uiState = MutableStateFlow(MovieDetailState())

    private val movieId = savedStateHandle.get<Int>(MOVIE_ID_KEY)

    init {
        getMovie()
        getActors()
    }

    private fun getMovie() {
        movieId ?: return

        viewModelScope.launch {
            movieDetailUseCases.getMovie(movieId)
                .onSuccess {
                    uiState.value = uiState.value.copy(
                        movie = it
                    )
                }
        }
    }

    private fun getActors() {
        viewModelScope.launch {
            movieDetailUseCases.getActors()
                .onSuccess {
                    uiState.value = uiState.value.copy(
                        actors = it
                    )
                }
        }
    }
}