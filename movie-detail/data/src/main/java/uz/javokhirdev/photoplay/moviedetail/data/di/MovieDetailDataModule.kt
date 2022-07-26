package uz.javokhirdev.photoplay.moviedetail.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.javokhirdev.photoplay.moviedetail.data.repository.MovieDetailRepositoryImpl
import uz.javokhirdev.photoplay.moviedetail.domain.repository.MovieDetailRepository

@Module
@InstallIn(SingletonComponent::class)
interface MovieDetailDataModule {

    @[Binds]
    fun bindMovieDetailRepository(impl: MovieDetailRepositoryImpl): MovieDetailRepository
}