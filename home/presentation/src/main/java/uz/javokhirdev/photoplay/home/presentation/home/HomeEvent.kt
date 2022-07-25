package uz.javokhirdev.photoplay.home.presentation.home

sealed class HomeEvent {
    object OnRandomMovieClick : HomeEvent()
    object OnWatchingItemClick : HomeEvent()
}