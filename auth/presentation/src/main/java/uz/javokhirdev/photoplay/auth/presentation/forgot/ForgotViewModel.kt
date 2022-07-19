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
import javax.inject.Inject

@HiltViewModel
class ForgotViewModel @Inject constructor(
    private val repository: AuthRepository,
) : ViewModel() {

    val uiState = MutableStateFlow(ForgotState())

    fun handleEvent(event: ForgotEvent) {
        when (event) {
            is ForgotEvent.EmailChanged -> updateEmail(event.email)
            ForgotEvent.OnSendClick -> sendEmail()
        }
    }

    private fun updateEmail(email: String) {
        uiState.value = uiState.value.copy(
            email = email
        )
    }

    private fun sendEmail() {
        onLoading()

        viewModelScope.launch(Dispatchers.IO) {
            delay(2000L)

            repository
                .forgotPassword(email = uiState.value.email.orEmpty())
                .onSuccess { onSuccess() }
                .onFailure { onError(it) }
        }
    }

    private fun onLoading() {
        uiState.value = uiState.value.copy(
            isLoading = true,
            isSuccess = false,
            error = null
        )
    }

    private suspend fun onSuccess() {
        withContext(Dispatchers.Main) {
            uiState.value = uiState.value.copy(
                isLoading = false,
                isSuccess = true,
                error = null
            )
        }
    }

    private suspend fun onError(throwable: Throwable) {
        withContext(Dispatchers.Main) {
            uiState.value = uiState.value.copy(
                isLoading = false,
                isSuccess = false,
                error = throwable.message.orEmpty()
            )
        }
    }
}