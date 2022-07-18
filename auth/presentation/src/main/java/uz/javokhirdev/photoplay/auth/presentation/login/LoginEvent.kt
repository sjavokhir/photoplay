package uz.javokhirdev.photoplay.auth.presentation.login

sealed class LoginEvent {
    data class EmailChanged(val email: String) : LoginEvent()
    data class PasswordChanged(val password: String) : LoginEvent()

    object OnLoginClick : LoginEvent()
    object OnRegisterClick : LoginEvent()
    object OnForgotClick : LoginEvent()

    object ErrorDismissed : LoginEvent()
}