// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
}

subprojects {
    // 1. Set the JVM Toolchain for all modules (Java and Kotlin)
    // This automatically sets compileJava and compileKotlin to version 17
    // and resolves the "Inconsistent JVM-target" error.
    plugins.withId("org.jetbrains.kotlin.jvm") {
        extensions.configure<org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension> {
            jvmToolchain(17)
        }
    }

    // For Android-specific Kotlin modules
    plugins.withId("org.jetbrains.kotlin.android") {
        extensions.configure<org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension> {
            jvmToolchain(17)
        }
    }

    // 2. Configure Android-specific settings (App and Library modules)
    plugins.withId("com.android.base") {
        extensions.configure<com.android.build.gradle.BaseExtension>("android") {
            compileOptions {
                // Ensure Java compatibility is set to 17
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17

                // Enables support for modern Java APIs on older Android devices
                isCoreLibraryDesugaringEnabled = true
            }
        }

        // Add the desugaring library to all Android modules
        dependencies {
            add("coreLibraryDesugaring", libs.android.desugar)
        }
    }

    // 3. Fine-tune Kotlin compilation tasks
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)

            // Helpful for Kotlin 2.0.0+ projects
            freeCompilerArgs.addAll(
                "-Xjsr305=strict",
                "-opt-in=kotlin.RequiresOptIn"
            )
        }
    }
}
