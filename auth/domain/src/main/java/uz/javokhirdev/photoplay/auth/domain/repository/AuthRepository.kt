package uz.javokhirdev.photoplay.auth.domain.repository

import uz.javokhirdev.photoplay.core.domain.model.UserInfo

interface AuthRepository {

    suspend fun login(
        email: String,
        password: String
    ): Result<UserInfo>

    suspend fun register(userInfo: UserInfo): Result<Boolean>

    suspend fun forgotPassword(email: String): Result<Boolean>
}