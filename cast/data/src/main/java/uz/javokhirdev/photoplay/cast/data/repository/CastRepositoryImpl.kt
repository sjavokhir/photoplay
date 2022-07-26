package uz.javokhirdev.photoplay.cast.data.repository

import uz.javokhirdev.photoplay.cast.domain.repository.CastRepository
import uz.javokhirdev.photoplay.core.data.DataSource
import uz.javokhirdev.photoplay.core.domain.model.Actor
import uz.javokhirdev.photoplay.core.domain.model.Movie
import javax.inject.Inject

class CastRepositoryImpl @Inject constructor() : CastRepository {

    override fun getActorById(id: Int): Result<Actor?> {
        return try {
            Result.success(DataSource.getActors().find { it.id == id })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun getKnownFor(): Result<List<Movie>> {
        return try {
            Result.success(DataSource.getWatchings().shuffled())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}