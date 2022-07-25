package uz.javokhirdev.photoplay.cast.domain.usecase

import uz.javokhirdev.photoplay.cast.domain.repository.CastRepository
import uz.javokhirdev.photoplay.core.domain.model.Actor

class GetActor(
    private val repository: CastRepository
) {

    operator fun invoke(id: Int): Result<Actor?> {
        return repository.getActorById(id)
    }
}