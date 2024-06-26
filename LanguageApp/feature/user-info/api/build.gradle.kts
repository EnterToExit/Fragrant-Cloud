plugins {
    id(libs.plugins.androidLibrary.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    id(libs.plugins.jetBrainsKotlin.get().pluginId)
}

android {
    compileSdk = 34
    namespace = "my.surop.feature.userinfo.api"
    defaultConfig {
        minSdk = 30
    }
    lint {
        targetSdk = 34
    }
}