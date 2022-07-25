package uz.javokhirdev.photoplay.moviedetail.presentation

sealed class MovieDetailEvent {
    object OnWatchClick : MovieDetailEvent()
    object OnCastClick : MovieDetailEvent()
}