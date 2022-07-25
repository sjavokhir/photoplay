package uz.javokhirdev.photoplay.downloads.data.repository

import uz.javokhirdev.photoplay.core.data.DataSource
import uz.javokhirdev.photoplay.core.domain.model.Download
import uz.javokhirdev.photoplay.downloads.domain.repository.DownloadsRepository
import javax.inject.Inject

class DownloadsRepositoryImpl @Inject constructor() : DownloadsRepository {

    override fun getDownloads(): Result<List<Download>> {
        return try {
            Result.success(DataSource.getDownloads())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}