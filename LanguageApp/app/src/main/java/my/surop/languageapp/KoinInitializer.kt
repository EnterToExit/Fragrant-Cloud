package my.surop.languageapp

import android.content.Context
import androidx.startup.Initializer
import my.surop.core.storage.impl.keyvalue.di.KeyValueStorageModule
import my.surop.core.storage.impl.secret.di.SecretsStorageModule
import my.surop.core.storage.impl.usercontext.di.UserContextStorageModule
import my.surop.feature.entrance.impl.di.EntranceModule
import my.surop.feature.mainscreen.impl.di.MainScreenModule
import my.surop.feature.onboarding.impl.di.OnboardingModule
import my.surop.feature.userinfo.impl.di.UserInfoModule
import my.surop.languageapp.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class KoinInitializer: Initializer<KoinApplication> {
    override fun create(context: Context): KoinApplication =
        startKoin {
            androidContext(context)
            modules(
                OnboardingModule,
                KeyValueStorageModule,
                UserContextStorageModule,
                SecretsStorageModule,
                MainScreenModule,
                EntranceModule,
                AppModule,
                UserInfoModule
            )
        }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> = mutableListOf()

}