package uz.javokhirdev.photoplay.search.presentation

sealed class SearchEvent {
    data class OnQueryChange(val query: String) : SearchEvent()
    object OnSearch : SearchEvent()
}