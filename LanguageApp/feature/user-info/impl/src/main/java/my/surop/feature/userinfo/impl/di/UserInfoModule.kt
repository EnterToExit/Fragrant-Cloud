package my.surop.feature.userinfo.impl.di

import my.surop.core.storage.api.secret.SecretsStorageProvider
import my.surop.feature.userinfo.api.AuthenticationStorage
import my.surop.feature.userinfo.api.UserRepository
import my.surop.feature.userinfo.impl.AuthenticationStorageImpl
import my.surop.feature.userinfo.impl.UserRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val AUTH_ALIAS = "auth"

val UserInfoModule = module {
    single<UserRepository> {
        UserRepositoryImpl(
            authentication = get(),
            userContextStorage = get()
        )
    }
    single<AuthenticationStorage>{
        AuthenticationStorageImpl(
            secretStorage = get<SecretsStorageProvider>().get(AUTH_ALIAS)
        )
    }
}
