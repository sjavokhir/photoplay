package uz.javokhirdev.photoplay.auth.presentation.forgot

import uz.javokhirdev.photoplay.auth.presentation.login.LoginEvent

sealed class ForgotEvent {
    data class EmailChanged(val email: String) : ForgotEvent()

    object OnSendClick : ForgotEvent()

    object ErrorDismissed : ForgotEvent()
}