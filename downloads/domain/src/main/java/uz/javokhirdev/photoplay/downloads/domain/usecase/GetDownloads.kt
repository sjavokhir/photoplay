package uz.javokhirdev.photoplay.downloads.domain.usecase

import uz.javokhirdev.photoplay.core.domain.model.Download
import uz.javokhirdev.photoplay.downloads.domain.repository.DownloadsRepository

class GetDownloads(
    private val repository: DownloadsRepository
) {

    operator fun invoke(): Result<List<Download>> {
        return repository.getDownloads()
    }
}