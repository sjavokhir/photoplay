package uz.javokhirdev.photoplay.cast.domain.repository

import uz.javokhirdev.photoplay.core.domain.model.Actor
import uz.javokhirdev.photoplay.core.domain.model.Movie

interface CastRepository {

    fun getActorById(id: Int): Result<Actor?>

    fun getKnownFor(): Result<List<Movie>>
}