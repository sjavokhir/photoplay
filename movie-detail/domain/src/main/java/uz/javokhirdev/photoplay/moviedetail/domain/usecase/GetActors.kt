package uz.javokhirdev.photoplay.moviedetail.domain.usecase

import uz.javokhirdev.photoplay.core.domain.model.Actor
import uz.javokhirdev.photoplay.moviedetail.domain.repository.MovieDetailRepository

class GetActors(
    private val repository: MovieDetailRepository
) {

    operator fun invoke(): Result<List<Actor>> {
        return repository.getActors()
    }
}