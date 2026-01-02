plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.fjjukic.mindtrack.data"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
    }
}

dependencies {
    coreLibraryDesugaring(libs.android.desugar)

    implementation(project(":domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.core)

    testImplementation(kotlin("test"))
    testImplementation(libs.kotlinx.coroutines.test)
}
