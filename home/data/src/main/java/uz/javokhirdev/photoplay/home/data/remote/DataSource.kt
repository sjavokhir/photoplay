package uz.javokhirdev.photoplay.home.data.remote

import uz.javokhirdev.photoplay.core.domain.model.Movie

object DataSource {

    fun getWatchings(): List<String> {
        return ArrayList<String>().apply {
            add("file:///android_asset/movies/image_01.png")
            add("file:///android_asset/movies/image_02.png")
            add("file:///android_asset/movies/image_03.png")
            add("file:///android_asset/movies/image_04.png")
            add("file:///android_asset/movies/image_05.png")
            add("file:///android_asset/movies/image_06.png")
            add("file:///android_asset/movies/image_07.png")
            add("file:///android_asset/movies/image_08.png")
        }
    }

    fun getMovies(): List<Movie> {
        return ArrayList<Movie>().apply {
            add(
                Movie(
                    id = 1,
                    name = null,
                    description = null,
                    imageUrl = "file:///android_asset/movies/image_01.png",
                    rating = null,
                    genres = null,
                    actors = null,
                )
            )
        }
    }
}