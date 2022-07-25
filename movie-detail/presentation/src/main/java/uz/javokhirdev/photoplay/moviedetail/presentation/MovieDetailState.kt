package uz.javokhirdev.photoplay.moviedetail.presentation

import uz.javokhirdev.photoplay.core.domain.model.Actor
import uz.javokhirdev.photoplay.core.domain.model.Movie

data class MovieDetailState(
    val movie: Movie? = null,
    val actors: List<Actor>? = null
)