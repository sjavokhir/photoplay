package uz.javokhirdev.photoplay.core.domain.preferences

import uz.javokhirdev.photoplay.core.domain.model.UserInfo

interface Preferences {
    fun saveUserInfo(userInfo: UserInfo)
    fun loadUserInfo(): UserInfo

    fun saveShouldShowLogin(shouldShow: Boolean)
    fun loadShouldShowLogin(): Boolean

    companion object {
        const val KEY_FIRST_NAME = "key_first_name"
        const val KEY_LAST_NAME = "key_last_name"
        const val KEY_EMAIL = "key_email"
        const val KEY_SHOULD_SHOW_LOGIN = "key_should_show_login"
    }
}