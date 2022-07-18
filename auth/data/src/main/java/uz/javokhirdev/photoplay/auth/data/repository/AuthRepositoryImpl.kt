package uz.javokhirdev.photoplay.auth.data.repository

import uz.javokhirdev.photoplay.auth.domain.repository.AuthRepository
import uz.javokhirdev.photoplay.core.data.preferences.DefaultPreferences
import uz.javokhirdev.photoplay.core.domain.model.UserInfo

class AuthRepositoryImpl(private val preferences: DefaultPreferences) : AuthRepository {

    override suspend fun login(
        email: String,
        password: String
    ): Result<UserInfo> {
        return try {
            val userInfo = UserInfo(
                firstName = "Your first name",
                lastName = "Your last name",
                email = email
            )
            preferences.saveUserInfo(userInfo)

            Result.success(userInfo)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun register(userInfo: UserInfo): Result<Boolean> {
        return try {
            preferences.saveUserInfo(userInfo)

            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun forgotPassword(email: String): Result<Boolean> {
        return try {
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}