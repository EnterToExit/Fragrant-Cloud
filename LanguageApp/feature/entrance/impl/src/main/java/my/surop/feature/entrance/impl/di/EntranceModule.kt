package my.surop.feature.entrance.impl.di

import my.surop.feature.entrance.api.EntranceFeature
import my.surop.feature.entrance.impl.navigation.EntranceFeatureImpl
import my.surop.feature.entrance.impl.presentation.EntranceScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val EntranceModule = module {
    factory<EntranceFeature> { EntranceFeatureImpl() }
    viewModel { EntranceScreenViewModel(userRepository = get()) }
}