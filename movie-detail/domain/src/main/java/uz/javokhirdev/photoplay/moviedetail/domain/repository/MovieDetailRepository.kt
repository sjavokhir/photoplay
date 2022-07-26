package uz.javokhirdev.photoplay.moviedetail.domain.repository

import uz.javokhirdev.photoplay.core.domain.model.Actor
import uz.javokhirdev.photoplay.core.domain.model.Movie

interface MovieDetailRepository {

    fun getMovieById(id: Int): Result<Movie?>

    fun getActors(): Result<List<Actor>>
}