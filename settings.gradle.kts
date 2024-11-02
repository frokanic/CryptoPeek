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

rootProject.name = "CryptoPeek"
include(":app")
include(":core")
include(":core:data")
include(":core:database")
include(":core:network")
include(":core:domain")
include(":core:model")
include(":core:designsystem")
include(":core:navigation")
include(":shared")
include(":feature")
include(":feature:allcrypto")
include(":feature:cryptodetails")
include(":shared")
