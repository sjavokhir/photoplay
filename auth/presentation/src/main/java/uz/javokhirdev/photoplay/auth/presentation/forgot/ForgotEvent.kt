package uz.javokhirdev.photoplay.auth.presentation.forgot

sealed class ForgotEvent {
    data class EmailChanged(val email: String) : ForgotEvent()

    object OnSendClick : ForgotEvent()
}