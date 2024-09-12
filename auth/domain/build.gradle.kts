plugins {
    alias(libs.plugins.coffeenerd.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.gulderbone.auth.domain"
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}