package uz.javokhirdev.photoplay.search.domain.usecase

import uz.javokhirdev.photoplay.core.domain.model.GroupMovie
import uz.javokhirdev.photoplay.search.domain.repository.SearchRepository

class GetSearch(
    private val repository: SearchRepository
) {

    operator fun invoke(query: String): Result<List<GroupMovie>> {
        return repository.search(query)
    }
}