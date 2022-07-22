package uz.javokhirdev.photoplay.home.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.javokhirdev.photoplay.home.data.repository.HomeRepositoryImpl
import uz.javokhirdev.photoplay.home.domain.repository.HomeRepository

@Module
@InstallIn(SingletonComponent::class)
interface HomeDataModule {

    @[Binds]
    fun bindHomeRepository(impl: HomeRepositoryImpl): HomeRepository
}