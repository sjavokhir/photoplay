package uz.javokhirdev.photoplay.search.data.repository

import uz.javokhirdev.photoplay.core.data.DataSource
import uz.javokhirdev.photoplay.core.domain.model.GroupMovie
import uz.javokhirdev.photoplay.search.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor() : SearchRepository {

    override fun search(query: String): Result<List<GroupMovie>> {
        return try {
            Result.success(DataSource.getSearch())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}