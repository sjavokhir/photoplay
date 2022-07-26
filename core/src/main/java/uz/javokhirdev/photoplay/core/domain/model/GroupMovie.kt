package uz.javokhirdev.photoplay.core.domain.model

data class GroupMovie(
    val title: String = "",
    val movies: List<Movie> = emptyList()
)