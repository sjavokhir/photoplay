package uz.javokhirdev.photoplay.core.data.preferences

import android.content.SharedPreferences
import uz.javokhirdev.photoplay.core.domain.model.UserInfo
import uz.javokhirdev.photoplay.core.domain.preferences.Preferences
import javax.inject.Inject

class DefaultPreferences @Inject constructor(
    private val sharedPref: SharedPreferences
) : Preferences {

    override fun saveUserInfo(userInfo: UserInfo) {
        sharedPref.edit()
            .putString(Preferences.KEY_FIRST_NAME, userInfo.firstName)
            .putString(Preferences.KEY_LAST_NAME, userInfo.lastName)
            .putString(Preferences.KEY_EMAIL, userInfo.email)
            .apply()
    }

    override fun loadUserInfo(): UserInfo {
        val firstName = sharedPref.getString(Preferences.KEY_FIRST_NAME, "").orEmpty()
        val lastName = sharedPref.getString(Preferences.KEY_LAST_NAME, "").orEmpty()
        val email = sharedPref.getString(Preferences.KEY_EMAIL, "").orEmpty()

        return UserInfo(
            firstName = firstName,
            lastName = lastName,
            email = email
        )
    }

    override fun saveShouldShowLogin(shouldShow: Boolean) {
        sharedPref.edit()
            .putBoolean(Preferences.KEY_SHOULD_SHOW_LOGIN, shouldShow)
            .apply()
    }

    override fun loadShouldShowLogin(): Boolean {
        return sharedPref.getBoolean(
            Preferences.KEY_SHOULD_SHOW_LOGIN,
            true
        )
    }
}