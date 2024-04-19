package my.surop.core.storage.impl.usercontext.di

import my.surop.core.storage.api.usercontext.UserContextStorage
import my.surop.core.storage.impl.usercontext.UserContextStorageProvider
import org.koin.dsl.module

/**
 * A module for KeyValueStorage feature
 */
val UserContextStorageModule = module() {
    single<UserContextStorage> {
        UserContextStorageProvider.get(kvsProvider = get())
    }
}