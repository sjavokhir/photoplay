package uz.javokhirdev.photoplay.auth.presentation.login

import uz.javokhirdev.photoplay.auth.domain.model.PasswordRequirements

data class LoginState(
    val email: String? = null,
    val password: String? = null,
    val passwordRequirements: List<PasswordRequirements> = emptyList(),
    val isEmailHintVisible: Boolean = false,
    val isPasswordHintVisible: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
) {
    fun isFormValid(): Boolean {
        return password?.isNotEmpty() == true &&
                email?.isNotEmpty() == true &&
                (passwordRequirements.containsAll(PasswordRequirements.values().toList()))
    }
}