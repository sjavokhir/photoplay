package uz.javokhirdev.photoplay.auth.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.javokhirdev.photoplay.auth.data.repository.AuthRepositoryImpl
import uz.javokhirdev.photoplay.auth.domain.repository.AuthRepository
import uz.javokhirdev.photoplay.core.data.preferences.DefaultPreferences
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthDataModule {

    @[Provides Singleton]
    fun provideAuthRepository(defaultPreferences: DefaultPreferences): AuthRepository {
        return AuthRepositoryImpl(preferences = defaultPreferences)
    }
}