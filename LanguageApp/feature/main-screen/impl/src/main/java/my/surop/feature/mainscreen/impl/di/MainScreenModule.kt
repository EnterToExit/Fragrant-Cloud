package my.surop.feature.mainscreen.impl.di

import my.surop.feature.mainscreen.api.MainScreenFeature
import my.surop.feature.mainscreen.impl.navigation.MainScreenFeatureImpl
import org.koin.dsl.module

val MainScreenModule = module {
    factory<MainScreenFeature> {
        MainScreenFeatureImpl()
    }
}

