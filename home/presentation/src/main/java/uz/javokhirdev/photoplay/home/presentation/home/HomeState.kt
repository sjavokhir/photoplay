package uz.javokhirdev.photoplay.home.presentation.home

import uz.javokhirdev.photoplay.core.domain.model.Movie

data class HomeState(
    val randomMovie: Movie? = null,
    val watchings: List<Movie>? = null
)