package uz.javokhirdev.photoplay.cast.presentation

import uz.javokhirdev.photoplay.core.domain.model.Actor
import uz.javokhirdev.photoplay.core.domain.model.Movie

data class CastState(
    val actor: Actor? = null,
    val movies: List<Movie>? = null
)