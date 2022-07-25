package uz.javokhirdev.photoplay.cast.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.javokhirdev.photoplay.cast.data.repository.CastRepositoryImpl
import uz.javokhirdev.photoplay.cast.domain.repository.CastRepository

@Module
@InstallIn(SingletonComponent::class)
interface CastDataModule {

    @[Binds]
    fun bindCastRepository(impl: CastRepositoryImpl): CastRepository
}