package uz.javokhirdev.photoplay.search.presentation

import uz.javokhirdev.photoplay.core.domain.model.GroupMovie

data class SearchState(
    val query: String = "",
    val isSearching: Boolean = false,
    val movies: List<GroupMovie> = emptyList()
)