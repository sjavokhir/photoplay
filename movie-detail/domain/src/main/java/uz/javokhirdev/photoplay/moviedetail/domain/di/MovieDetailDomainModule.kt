package uz.javokhirdev.photoplay.moviedetail.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import uz.javokhirdev.photoplay.moviedetail.domain.usecase.GetMovie
import uz.javokhirdev.photoplay.moviedetail.domain.usecase.GetActors
import uz.javokhirdev.photoplay.moviedetail.domain.usecase.MovieDetailUseCases
import uz.javokhirdev.photoplay.moviedetail.domain.repository.MovieDetailRepository

@Module
@InstallIn(ViewModelComponent::class)
object MovieDetailDomainModule {

    @ViewModelScoped
    @Provides
    fun provideMovieDetailUseCases(repository: MovieDetailRepository): MovieDetailUseCases {
        return MovieDetailUseCases(
            getMovie = GetMovie(repository),
            getActors = GetActors(repository),
        )
    }
}