package uz.javokhirdev.photoplay.auth.presentation.login

data class LoginState(
    val email: String? = null,
    val password: String? = null,
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val error: String? = null
)