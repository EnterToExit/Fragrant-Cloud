package my.surop.feature.userinfo.impl

import my.surop.core.storage.api.usercontext.UserContextStorage
import my.surop.feature.userinfo.api.AuthenticationStorage
import my.surop.feature.userinfo.api.UserRepository
import my.surop.feature.userinfo.api.model.UserInfo

private const val FIRST_NAME_KEY = "fnk"
private const val LAST_NAME_KEY = "lnk"
private const val EMAIL_KEY = "emk"

internal class UserRepositoryImpl(
    override val authentication: AuthenticationStorage,
    private val userContextStorage: UserContextStorage
): UserRepository {
    override fun getCurrentUser(): UserInfo? = with(userContextStorage.reader) {
        if (!contains(EMAIL_KEY)) return@with null
        UserInfo(
            firstName = getString(FIRST_NAME_KEY)!!,
            lastName = getString(LAST_NAME_KEY)!!,
            email = getString(EMAIL_KEY)!!
        )
    }

    override fun saveUser(user: UserInfo) {
        userContextStorage.writer.update {
            it.setString(FIRST_NAME_KEY, user.firstName)
            it.setString(LAST_NAME_KEY, user.lastName)
            it.setString(EMAIL_KEY, user.email)
        }
    }

    override fun clearAll() {
        authentication.clear()
        userContextStorage.clear()
    }
}