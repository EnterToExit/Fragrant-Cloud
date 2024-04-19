package my.surop.feature.onboarding.api

import my.surop.core.navigation.FeatureNavigationApi

interface OnboardingFeature : FeatureNavigationApi {
    val route: String
}