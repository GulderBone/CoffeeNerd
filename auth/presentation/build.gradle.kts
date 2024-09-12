plugins {
    alias(libs.plugins.coffeenerd.android.feature.ui)
    alias(libs.plugins.coffeenerd.android.hilt)
}

android {
    namespace = "com.gulderbone.auth.presentation"
}

dependencies {
    implementation(projects.auth.domain)
}
