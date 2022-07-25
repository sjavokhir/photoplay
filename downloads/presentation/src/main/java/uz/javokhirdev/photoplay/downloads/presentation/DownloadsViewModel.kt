package uz.javokhirdev.photoplay.downloads.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.javokhirdev.photoplay.downloads.domain.usecase.DownloadsUseCases
import javax.inject.Inject

@HiltViewModel
class DownloadsViewModel @Inject constructor(
    private val downloadsUseCases: DownloadsUseCases
) : ViewModel() {

    val uiState = MutableStateFlow(DownloadsState())

    init {
        getDownloads()
    }

    private fun getDownloads() {
        viewModelScope.launch {
            downloadsUseCases.getDownloads.invoke()
                .onSuccess {
                    uiState.value = uiState.value.copy(
                        downloads = it
                    )
                }
        }
    }
}