package uz.javokhirdev.photoplay.auth.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.javokhirdev.photoplay.auth.domain.model.PasswordRequirements
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
            LoginEvent.OnRegisterClick -> {}
            LoginEvent.OnForgotClick -> {}
            LoginEvent.ErrorDismissed -> dismissError()
        }
    }

    private fun updateEmail(email: String) {
        uiState.value = uiState.value.copy(
            email = email
        )
    }

    private fun updatePassword(password: String) {
        val requirements = mutableListOf<PasswordRequirements>()

        if (password.length > 7) {
            requirements.add(PasswordRequirements.EIGHT_CHARACTERS)
        }
        if (password.any { it.isUpperCase() }) {
            requirements.add(PasswordRequirements.CAPITAL_LETTER)
        }
        if (password.any { it.isDigit() }) {
            requirements.add(PasswordRequirements.NUMBER)
        }

        uiState.value = uiState.value.copy(
            password = password,
            passwordRequirements = requirements.toList()
        )
    }

    private fun login() {
        uiState.value = uiState.value.copy(
            isLoading = true
        )

        viewModelScope.launch(Dispatchers.IO) {
            delay(2000L)

            repository
                .login(
                    email = uiState.value.email.orEmpty(),
                    password = uiState.value.password.orEmpty()
                )
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