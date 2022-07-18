package uz.javokhirdev.photoplay.auth.presentation.register

import uz.javokhirdev.photoplay.auth.domain.model.PasswordRequirements

data class RegisterState(
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String? = null,
    val password: String? = null,
    val confirmPassword: String? = null,
    val passwordRequirements: List<PasswordRequirements> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) {
    fun isFormValid(): Boolean {
        return password?.isNotEmpty() == true &&
                email?.isNotEmpty() == true &&
                (passwordRequirements.containsAll(PasswordRequirements.values().toList()))
    }
}