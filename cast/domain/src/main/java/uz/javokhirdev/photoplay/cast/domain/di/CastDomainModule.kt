package uz.javokhirdev.photoplay.cast.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import uz.javokhirdev.photoplay.cast.domain.repository.CastRepository
import uz.javokhirdev.photoplay.cast.domain.usecase.CastUseCases
import uz.javokhirdev.photoplay.cast.domain.usecase.GetActor
import uz.javokhirdev.photoplay.cast.domain.usecase.GetKnownFor

@Module
@InstallIn(ViewModelComponent::class)
object CastDomainModule {

    @ViewModelScoped
    @Provides
    fun provideMovieDetailUseCases(repository: CastRepository): CastUseCases {
        return CastUseCases(
            getActor = GetActor(repository),
            getKnownFor = GetKnownFor(repository),
        )
    }
}