package uz.javokhirdev.photoplay.cast.domain.usecase

import uz.javokhirdev.photoplay.cast.domain.repository.CastRepository
import uz.javokhirdev.photoplay.core.domain.model.Movie

class GetKnownFor(
    private val repository: CastRepository
) {

    operator fun invoke(): Result<List<Movie>> {
        return repository.getKnownFor()
    }
}