package uz.javokhirdev.photoplay.auth.presentation.forgot

data class ForgotState(
    val email: String? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)