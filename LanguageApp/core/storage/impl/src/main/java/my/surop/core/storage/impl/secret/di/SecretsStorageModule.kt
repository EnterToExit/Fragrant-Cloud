package my.surop.core.storage.impl.secret.di

import my.surop.core.storage.api.secret.SecretsStorageProvider
import my.surop.core.storage.impl.secret.SecretsStorageProviderImpl
import org.koin.dsl.module

/**
 * Модуль реализации функционала хранения секретов на устройстве
 */
val SecretsStorageModule = module(createdAtStart = false) {
    factory<SecretsStorageProvider> {
        SecretsStorageProviderImpl(
            keyValueStorageFactory = get()
        )
    }
}
