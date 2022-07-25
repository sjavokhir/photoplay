package uz.javokhirdev.photoplay.downloads.presentation

sealed class DownloadsEvent {
    object OnDownloadClick : DownloadsEvent()
}