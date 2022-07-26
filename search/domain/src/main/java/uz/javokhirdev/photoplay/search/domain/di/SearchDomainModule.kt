package uz.javokhirdev.photoplay.search.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import uz.javokhirdev.photoplay.search.domain.repository.SearchRepository
import uz.javokhirdev.photoplay.search.domain.usecase.GetSearch
import uz.javokhirdev.photoplay.search.domain.usecase.SearchUseCases

@Module
@InstallIn(ViewModelComponent::class)
object SearchDomainModule {

    @ViewModelScoped
    @Provides
    fun provideSearchUseCases(repository: SearchRepository): SearchUseCases {
        return SearchUseCases(
            search = GetSearch(repository)
        )
    }
}