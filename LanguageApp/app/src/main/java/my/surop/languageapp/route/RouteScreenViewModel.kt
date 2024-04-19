package my.surop.languageapp.route

import my.surop.languageapp.route.model.RouterScreenAction
import my.surop.languageapp.route.model.RouterScreenEvent
import my.surop.feature.onboarding.api.domain.OnboardingInteractor
import my.surop.feature.userinfo.api.UserRepository
import my.surop.core.architecture.mvi.MVIScreenModel
import my.surop.core.architecture.mvi.models.ActionShareBehavior
import my.surop.core.architecture.mvi.models.MVIConfiguration

/**
 * VM стартового экрана, содержит логику навигации
 */
internal class RouteScreenViewModel(
    private val onboardingScreenInteractor: OnboardingInteractor,
    private val userRepository: UserRepository,
) : MVIScreenModel<RouterScreenEvent, Unit, RouterScreenAction>(
    MVIConfiguration(
        initial = Unit,
        actionShareBehavior = ActionShareBehavior.Distribute()
    )
) {


    private val isCompletedOnboarding: Boolean
        get() = onboardingScreenInteractor.isOnboardingCompleted


    override suspend fun onEvent(event: RouterScreenEvent) {
        when (event) {
            RouterScreenEvent.ScreenShown -> reroute()
        }
    }

    private suspend fun reroute() {

        when {
            !isCompletedOnboarding -> {
                action(RouterScreenAction.ShowOnboarding)
            }
            userRepository.authentication.isAuthenticated -> {
                action(RouterScreenAction.NavigateToMain)
            }

            else -> {
                action(RouterScreenAction.NavigateToEntrance)

            }
        }
    }
}