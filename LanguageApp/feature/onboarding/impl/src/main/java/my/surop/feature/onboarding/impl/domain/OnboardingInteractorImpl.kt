package my.surop.feature.onboarding.impl.domain

import my.surop.core.storage.api.delegates.booleanPreference
import my.surop.core.storage.api.keyvalue.KeyValueStorage
import my.surop.feature.onboarding.api.domain.OnboardingInteractor

private const val COMPLETED_ONBOARDING = "cplonb"

internal class OnboardingInteractorImpl(kvStorage: KeyValueStorage): OnboardingInteractor {
    override var isOnboardingCompleted: Boolean by kvStorage.booleanPreference(COMPLETED_ONBOARDING)
}