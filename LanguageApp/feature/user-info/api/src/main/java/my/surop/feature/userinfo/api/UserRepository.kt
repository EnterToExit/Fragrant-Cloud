package my.surop.feature.userinfo.api

import my.surop.feature.userinfo.api.model.UserInfo

interface UserRepository {
    fun getCurrentUser(): UserInfo?
    fun saveUser(user: UserInfo)
    val authentication: AuthenticationStorage
    fun clearAll()
}