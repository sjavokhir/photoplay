package uz.javokhirdev.photoplay.home.data.repository

import uz.javokhirdev.photoplay.core.domain.model.Movie
import uz.javokhirdev.photoplay.home.data.remote.DataSource
import uz.javokhirdev.photoplay.home.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor() : HomeRepository {

    override fun getRandomMovie(): Result<Movie> {
        return try {
            Result.success(DataSource.getWatchings().random())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun getWatchings(): Result<List<Movie>> {
        return try {
            Result.success(DataSource.getWatchings())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}