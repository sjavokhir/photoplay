package uz.javokhirdev.photoplay.home.domain.usecase

import uz.javokhirdev.photoplay.core.domain.model.Movie
import uz.javokhirdev.photoplay.home.domain.repository.HomeRepository

class GetWatchings(
    private val repository: HomeRepository
) {

    operator fun invoke(): Result<List<Movie>> {
        return repository.getWatchings()
    }
}