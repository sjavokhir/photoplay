package uz.javokhirdev.photoplay.auth.presentation.register

sealed class RegisterEvent {
    data class FirstNameChanged(val firstName: String) : RegisterEvent()
    data class LastNameChanged(val lastName: String) : RegisterEvent()
    data class EmailChanged(val email: String) : RegisterEvent()
    data class PasswordChanged(val password: String) : RegisterEvent()
    data class ConfirmPasswordChanged(val confirmPassword: String) : RegisterEvent()

    object OnRegisterClick : RegisterEvent()

    object ErrorDismissed : RegisterEvent()
}