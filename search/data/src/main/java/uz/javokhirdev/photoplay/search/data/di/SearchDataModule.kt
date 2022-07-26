package uz.javokhirdev.photoplay.search.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.javokhirdev.photoplay.search.data.repository.SearchRepositoryImpl
import uz.javokhirdev.photoplay.search.domain.repository.SearchRepository

@Module
@InstallIn(SingletonComponent::class)
interface SearchDataModule {

    @[Binds]
    fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository
}