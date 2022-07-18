package uz.javokhirdev.photoplay.auth.presentation.forgot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.javokhirdev.photoplay.auth.domain.repository.AuthRepository
import uz.javokhirdev.photoplay.core.domain.preferences.Preferences
import javax.inject.Inject

@HiltViewModel
class ForgotViewModel @Inject constructor(
    preferences: Preferences,
    private val repository: AuthRepository,
) : ViewModel() {

    val uiState = MutableStateFlow(ForgotState())

    init {
        preferences.saveShouldShowLogin(true)
    }

    fun handleEvent(event: ForgotEvent) {
        when (event) {
            is ForgotEvent.EmailChanged -> updateEmail(event.email)
            ForgotEvent.OnSendClick -> sendEmail()
            ForgotEvent.ErrorDismissed -> {}
        }
    }

    private fun updateEmail(email: String) {
        uiState.value = uiState.value.copy(
            email = email
        )
    }

    private fun sendEmail() {
        uiState.value = uiState.value.copy(
            isLoading = true
        )

        viewModelScope.launch(Dispatchers.IO) {
            delay(2000L)

            repository
                .forgotPassword(email = uiState.value.email.orEmpty())
                .onSuccess {
                    withContext(Dispatchers.Main) {
                        uiState.value = uiState.value.copy(
                            isLoading = false,
                        )
                    }
                }
                .onFailure {
                    withContext(Dispatchers.Main) {
                        uiState.value = uiState.value.copy(
                            isLoading = false,
                            error = it.message
                        )
                    }
                }
        }
    }

    private fun dismissError() {
        uiState.value = uiState.value.copy(
            error = null
        )
    }
}