package uz.javokhirdev.photoplay.profile.presentation

sealed class ProfileEvent {
    object OnRandomMovieClick : ProfileEvent()
    object OnWatchingItemClick : ProfileEvent()
}