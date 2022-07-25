package uz.javokhirdev.photoplay.downloads.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import uz.javokhirdev.photoplay.downloads.domain.repository.DownloadsRepository
import uz.javokhirdev.photoplay.downloads.domain.usecase.DownloadsUseCases
import uz.javokhirdev.photoplay.downloads.domain.usecase.GetDownloads

@Module
@InstallIn(ViewModelComponent::class)
object DownloadsDomainModule {

    @ViewModelScoped
    @Provides
    fun provideHomeUseCases(
        repository: DownloadsRepository,
    ): DownloadsUseCases {
        return DownloadsUseCases(
            getDownloads = GetDownloads(repository)
        )
    }
}