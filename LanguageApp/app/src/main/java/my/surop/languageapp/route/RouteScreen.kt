package my.surop.languageapp.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import my.surop.languageapp.route.model.RouterScreenAction
import my.surop.languageapp.route.model.RouterScreenEvent
import my.surop.core.architecture.mvi.dsl.collectActionsWithLifeсycle
import org.koin.androidx.compose.koinViewModel

const val ROUTE_SCREEN_ROUTE = "router"

/**
 * Экран навигации в засисимости от уровня доступа пользователя
 */
@Composable
internal fun RouteScreen(
    viewModel: RouteScreenViewModel = koinViewModel(),
    onShowOnboarding: () -> Unit,
    onNavigateToEntrance: () -> Unit,
    onNavigateToMain: () -> Unit,
) {
    LaunchedEffect(true) {
        viewModel.event(RouterScreenEvent.ScreenShown)
    }


    viewModel.collectActionsWithLifeсycle { action ->
        when (action) {
            RouterScreenAction.NavigateToMain -> onNavigateToMain()
            RouterScreenAction.ShowOnboarding -> onShowOnboarding()
            RouterScreenAction.NavigateToEntrance -> onNavigateToEntrance()
        }
    }
}
