package uz.javokhirdev.photoplay.auth.presentation.register

import uz.javokhirdev.photoplay.auth.domain.model.PasswordRequirement

data class RegisterState(
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String? = null,
    val password: String? = null,
    val confirmPassword: String? = null,
    val passwordRequirements: List<PasswordRequirement> = emptyList(),
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String? = null
)