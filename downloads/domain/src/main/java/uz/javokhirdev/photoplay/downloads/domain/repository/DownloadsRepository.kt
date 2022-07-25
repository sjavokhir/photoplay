package uz.javokhirdev.photoplay.downloads.domain.repository

import uz.javokhirdev.photoplay.core.domain.model.Download

interface DownloadsRepository {

    fun getDownloads(): Result<List<Download>>
}