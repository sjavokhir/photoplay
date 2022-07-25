package uz.javokhirdev.photoplay.downloads.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.javokhirdev.photoplay.downloads.data.repository.DownloadsRepositoryImpl
import uz.javokhirdev.photoplay.downloads.domain.repository.DownloadsRepository

@Module
@InstallIn(SingletonComponent::class)
interface DownloadsDataModule {

    @[Binds]
    fun bindDownloadsRepository(impl: DownloadsRepositoryImpl): DownloadsRepository
}