package my.surop.feature.entrance.api

import my.surop.core.navigation.FeatureNavigationApi

interface EntranceFeature: FeatureNavigationApi {
    val route: String
}