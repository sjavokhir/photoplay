package uz.javokhirdev.photoplay.app.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.javokhirdev.photoplay.core.data.preferences.DefaultPreferences
import uz.javokhirdev.photoplay.core.domain.preferences.Preferences
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @[Provides Singleton]
    fun provideSharedPreferences(
        app: Application
    ): SharedPreferences {
        return app.getSharedPreferences("app_prefs", MODE_PRIVATE)
    }

    @[Provides Singleton]
    fun providePreferences(sharedPreferences: SharedPreferences): Preferences {
        return DefaultPreferences(sharedPreferences)
    }
}