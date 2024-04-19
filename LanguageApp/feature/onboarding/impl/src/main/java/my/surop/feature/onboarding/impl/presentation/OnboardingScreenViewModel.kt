package my.surop.feature.onboarding.impl.presentation

import my.surop.feature.onboarding.api.domain.OnboardingInteractor
import my.surop.feature.onboarding.impl.presentation.model.OnboardingScreenAction
import my.surop.feature.onboarding.impl.presentation.model.OnboardingScreenEvent
import my.surop.feature.onboarding.impl.presentation.model.OnboardingScreenState
import my.surop.feature.onboarding.impl.presentation.model.OnboardingStep
import my.surop.core.architecture.mvi.MVIScreenModel
import my.surop.core.architecture.mvi.models.MVIConfiguration

internal class OnboardingScreenViewModel(
    private val interactor: OnboardingInteractor
) : MVIScreenModel<OnboardingScreenEvent, OnboardingScreenState, OnboardingScreenAction>(
    config = MVIConfiguration(
        initial = OnboardingScreenState(OnboardingStep.STEP_1)
    )
) {
    override suspend fun onEvent(event: OnboardingScreenEvent) {
        when (event) {
            OnboardingScreenEvent.ClickClose -> onCloseOnboarding()
            OnboardingScreenEvent.ClickNext -> {
                withState {
                    when (currentStep) {
                        OnboardingStep.STEP_1 -> updateState { OnboardingScreenState(OnboardingStep.STEP_2) }
                        OnboardingStep.STEP_2 -> updateState { OnboardingScreenState(OnboardingStep.STEP_3) }
                        OnboardingStep.STEP_3 -> onCloseOnboarding()
                    }
                }
            }
        }

    }

    private suspend fun onCloseOnboarding(){
        interactor.isOnboardingCompleted = true
        action(OnboardingScreenAction.NavigateToEntrance)
    }
}