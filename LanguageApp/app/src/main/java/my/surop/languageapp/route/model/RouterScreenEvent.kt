package my.surop.languageapp.route.model

sealed interface RouterScreenEvent {
    data object ScreenShown : RouterScreenEvent
}