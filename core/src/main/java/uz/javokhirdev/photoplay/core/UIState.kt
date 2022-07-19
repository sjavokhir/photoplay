package uz.javokhirdev.photoplay.core

sealed class UIState<out T> where T : Any? {
    object Idle : UIState<Nothing>()
    data class Loading(val isLoading: Boolean) : UIState<Nothing>()
    data class Success<T>(val data: T? = null) : UIState<T>()
    data class Failure(val message: String) : UIState<Nothing>()

    companion object {
        fun loading(isLoading: Boolean) = Loading(isLoading)
        fun <T> success(data: T? = null) = Success(data)
        fun failure(message: String) = Failure(message)
    }
}

infix fun <T> UIState<T>.onLoading(onLoading: (UIState.Loading) -> Unit): UIState<T> {
    return when (this) {
        is UIState.Loading -> {
            onLoading(this)
            this
        }
        else -> this
    }
}

infix fun <T> UIState<T>.onSuccess(onSuccess: (UIState.Success<T>) -> Unit): UIState<T> {
    return when (this) {
        is UIState.Success -> {
            onSuccess(this)
            this
        }
        else -> this
    }
}

infix fun <T> UIState<T>.onFailure(onFailure: (UIState.Failure) -> Unit): UIState<T> {
    return when (this) {
        is UIState.Failure -> {
            onFailure(this)
            this
        }
        else -> this
    }
}