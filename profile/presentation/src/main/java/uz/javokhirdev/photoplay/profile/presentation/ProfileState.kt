package uz.javokhirdev.photoplay.profile.presentation

import uz.javokhirdev.photoplay.core.domain.model.Movie

data class ProfileState(
    val randomMovie: Movie? = null,
    val watchings: List<Movie>? = null
)