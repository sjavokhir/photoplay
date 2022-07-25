package uz.javokhirdev.photoplay.moviedetail.data.repository

import uz.javokhirdev.photoplay.core.data.DataSource
import uz.javokhirdev.photoplay.core.domain.model.Actor
import uz.javokhirdev.photoplay.core.domain.model.Movie
import uz.javokhirdev.photoplay.moviedetail.domain.repository.MovieDetailRepository
import javax.inject.Inject

class MovieDetailRepositoryImpl @Inject constructor() : MovieDetailRepository {

    override fun getMovieById(id: Int): Result<Movie?> {
        return try {
            Result.success(DataSource.getWatchings().find { it.id == id })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun getActors(): Result<List<Actor>> {
        return try {
            Result.success(DataSource.getActors())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}