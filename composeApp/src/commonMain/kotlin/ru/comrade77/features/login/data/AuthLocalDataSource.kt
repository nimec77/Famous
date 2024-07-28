package ru.comrade77.features.login.data

interface AuthLocalDataSource {
    suspend fun checkToken(): String
}

class AuthEncryptedDataSource(): AuthLocalDataSource {
    override suspend fun checkToken(): String {
        return ""
    }

}