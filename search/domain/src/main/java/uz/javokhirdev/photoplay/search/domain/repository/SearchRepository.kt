package uz.javokhirdev.photoplay.search.domain.repository

import uz.javokhirdev.photoplay.core.domain.model.GroupMovie

interface SearchRepository {

    fun search(query: String): Result<List<GroupMovie>>
}