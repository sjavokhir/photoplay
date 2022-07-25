package uz.javokhirdev.photoplay.core.domain.model

data class Movie(
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val imageUrl: String? = null,
    val rating: Float? = null,
    val genres: List<String>? = null
)
