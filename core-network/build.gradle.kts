plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.fjjukic.mindtrack.core.network"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
    }
}

dependencies {
    coreLibraryDesugaring(libs.android.desugar)

    implementation(libs.androidx.core.ktx)
    testImplementation(kotlin("test"))
}
