package my.surop.feature.onboarding.impl.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import my.surop.feature.entrance.api.EntranceFeature
import my.surop.feature.onboarding.api.OnboardingFeature
import my.surop.feature.onboarding.impl.presentation.OnBoardingScreen
import org.koin.compose.koinInject

class OnboardingFeatureImpl : OnboardingFeature {
    override val route: String = "languageapp://onboarding"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route = route) {
            val entranceFeature = koinInject<EntranceFeature>()
            OnBoardingScreen(
                modifier = modifier,
                onNavigateToEntrance = {
                    navController.navigate(entranceFeature.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                    }
                }
            )
        }
    }
}