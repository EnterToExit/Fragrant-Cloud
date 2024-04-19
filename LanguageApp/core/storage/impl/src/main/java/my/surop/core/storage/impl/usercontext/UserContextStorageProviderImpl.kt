package my.surop.core.storage.impl.usercontext

import my.surop.core.storage.api.keyvalue.KeyValueStorageProvider
import my.surop.core.storage.api.usercontext.UserContextStorage

object UserContextStorageProvider{
    fun get(kvsProvider: KeyValueStorageProvider): UserContextStorage {
        return UserContextStorageImpl(kvsProvider)
    }
}