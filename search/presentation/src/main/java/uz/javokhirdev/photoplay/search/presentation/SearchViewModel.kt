package uz.javokhirdev.photoplay.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.javokhirdev.photoplay.search.domain.usecase.SearchUseCases
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCases: SearchUseCases
) : ViewModel() {

    val uiState = MutableStateFlow(SearchState())

    fun handleEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.OnQueryChange -> {
                uiState.value = uiState.value.copy(
                    query = event.query
                )
            }
            SearchEvent.OnSearch -> search()
        }
    }

    private fun search() {
        uiState.value = uiState.value.copy(
            isSearching = true,
            movies = emptyList()
        )

        viewModelScope.launch {
            searchUseCases
                .search(uiState.value.query)
                .onSuccess {
                    uiState.value = uiState.value.copy(
                        isSearching = false,
                        query = "",
                        movies = it
                    )
                }
                .onFailure {
                    uiState.value = uiState.value.copy(
                        isSearching = true,
                        movies = emptyList()
                    )
                }
        }
    }
}