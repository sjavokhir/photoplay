package uz.javokhirdev.photoplay.auth.presentation.login

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
class LoginViewModel @Inject constructor(
    preferences: Preferences,
    private val repository: AuthRepository,
) : ViewModel() {

    val uiState = MutableStateFlow(LoginState())

    init {
        preferences.saveShouldShowLogin(true)
    }

    fun handleEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChanged -> updateEmail(event.email)
            is LoginEvent.PasswordChanged -> updatePassword(event.password)
            LoginEvent.OnLoginClick -> login()
        }
    }

    private fun updateEmail(email: String) {
        uiState.value = uiState.value.copy(
            email = email
        )
    }

    private fun updatePassword(password: String) {
        uiState.value = uiState.value.copy(
            password = password
        )
    }

    private fun login() {
        onLoading()

        viewModelScope.launch(Dispatchers.IO) {
            delay(2000L)

            repository
                .login(
                    email = uiState.value.email.orEmpty(),
                    password = uiState.value.password.orEmpty()
                )
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