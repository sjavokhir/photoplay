package uz.javokhirdev.photoplay.auth.presentation.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.javokhirdev.photoplay.auth.domain.model.PasswordRequirement
import uz.javokhirdev.photoplay.auth.domain.repository.AuthRepository
import uz.javokhirdev.photoplay.core.domain.model.UserInfo
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: AuthRepository,
) : ViewModel() {

    val uiState = MutableStateFlow(RegisterState())

    fun handleEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.FirstNameChanged -> updateFirstName(event.firstName)
            is RegisterEvent.LastNameChanged -> updateLastName(event.lastName)
            is RegisterEvent.EmailChanged -> updateEmail(event.email)
            is RegisterEvent.PasswordChanged -> updatePassword(event.password)
            is RegisterEvent.ConfirmPasswordChanged -> updateConfirmPassword(event.confirmPassword)
            RegisterEvent.OnRegisterClick -> register()
        }
    }

    private fun updateFirstName(firstName: String) {
        uiState.value = uiState.value.copy(
            firstName = firstName
        )
    }

    private fun updateLastName(lastName: String) {
        uiState.value = uiState.value.copy(
            lastName = lastName
        )
    }

    private fun updateEmail(email: String) {
        uiState.value = uiState.value.copy(
            email = email
        )
    }

    private fun updatePassword(password: String) {
        val requirements = mutableListOf<PasswordRequirement>()

        if (password.length > 7) {
            requirements.add(PasswordRequirement.EIGHT_CHARACTERS)
        }
        if (password.any { it.isUpperCase() }) {
            requirements.add(PasswordRequirement.CAPITAL_LETTER)
        }
        if (password.any { it.isDigit() }) {
            requirements.add(PasswordRequirement.NUMBER)
        }

        uiState.value = uiState.value.copy(
            password = password,
            passwordRequirements = requirements.toList()
        )
    }

    private fun updateConfirmPassword(confirmPassword: String) {
        uiState.value = uiState.value.copy(
            confirmPassword = confirmPassword
        )
    }

    private fun register() {
        onLoading()

        viewModelScope.launch(Dispatchers.IO) {
            delay(2000L)

            repository
                .register(
                    UserInfo(
                        firstName = uiState.value.firstName.orEmpty(),
                        lastName = uiState.value.lastName.orEmpty(),
                        email = uiState.value.email.orEmpty()
                    )
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