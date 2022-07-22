package uz.javokhirdev.photoplay.home.domain.repository

import uz.javokhirdev.photoplay.core.domain.model.Movie

interface HomeRepository {

    fun getRandomMovie(): Result<Movie>

    fun getWatchings(): Result<List<String>>
}