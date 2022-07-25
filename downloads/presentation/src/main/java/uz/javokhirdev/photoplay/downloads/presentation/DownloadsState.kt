package uz.javokhirdev.photoplay.downloads.presentation

import uz.javokhirdev.photoplay.core.domain.model.Download

data class DownloadsState(
    val downloads: List<Download>? = null
)