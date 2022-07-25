package uz.javokhirdev.photoplay.moviedetail.domain.usecase

import uz.javokhirdev.photoplay.core.domain.model.Movie
import uz.javokhirdev.photoplay.moviedetail.domain.repository.MovieDetailRepository

class GetMovie(
    private val repository: MovieDetailRepository
) {

    operator fun invoke(id: Int): Result<Movie?> {
        return repository.getMovieById(id)
    }
}