pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MindTrack"
include(":app")
include(":domain")
include(":data")
include(":core-network")
include(":core-database")
include(":core-ui")
include(":feature-auth")
include(":feature-dashboard")
include(":feature-habits")
include(":feature-health")
include(":feature-settings")
