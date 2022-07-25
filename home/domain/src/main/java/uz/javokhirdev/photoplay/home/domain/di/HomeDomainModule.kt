package uz.javokhirdev.photoplay.home.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import uz.javokhirdev.photoplay.home.domain.repository.HomeRepository
import uz.javokhirdev.photoplay.home.domain.usecase.GetRandomMovie
import uz.javokhirdev.photoplay.home.domain.usecase.GetWatchings
import uz.javokhirdev.photoplay.home.domain.usecase.HomeUseCases

@Module
@InstallIn(ViewModelComponent::class)
object HomeDomainModule {

    @ViewModelScoped
    @Provides
    fun provideHomeUseCases(
        repository: HomeRepository,
    ): HomeUseCases {
        return HomeUseCases(
            getRandomMovie = GetRandomMovie(repository),
            getWatchings = GetWatchings(repository),
        )
    }
}