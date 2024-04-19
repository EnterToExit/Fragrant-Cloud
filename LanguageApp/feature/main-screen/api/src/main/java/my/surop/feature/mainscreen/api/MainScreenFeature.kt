package my.surop.feature.mainscreen.api

import my.surop.core.navigation.FeatureNavigationApi

interface MainScreenFeature: FeatureNavigationApi {
    val route: String
}