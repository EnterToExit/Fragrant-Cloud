package my.surop.feature.mainscreen.impl.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import my.surop.feature.mainscreen.api.MainScreenFeature
import my.surop.feature.mainscreen.impl.domain.model.Exercise
import my.surop.feature.mainscreen.impl.domain.model.User
import my.surop.feature.mainscreen.impl.presentation.MainScreen

internal class MainScreenFeatureImpl : MainScreenFeature {
    override val route: String = "languageapp://main"

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavHostController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(route) {
            MainScreen(
                modifier = modifier, exercises = Exercise.entries.drop(0), users = listOf(
                    User(
                        emoji = "\uD83D\uDC68\uD83C\uDFFB\u200D\uD83C\uDFA8",
                        name = "Vincent van Gogh",
                        points = 12
                    ), User(
                        emoji = "\uD83D\uDC68\uD83C\uDFFB\u200D\uD83C\uDFA8",
                        name = "Vincent van Gogh",
                        points = 12
                    ), User(
                        emoji = "\uD83D\uDC68\uD83C\uDFFB\u200D\uD83C\uDFA8",
                        name = "Vincent van Gogh",
                        points = 12
                    )
                )
            )
        }
    }
}