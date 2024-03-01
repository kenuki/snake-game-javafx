pluginManagement {
    plugins {
        kotlin("jvm") version (extra["kotlin_version"] as String)
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version ("0.5.0")
}

rootProject.name = "SnakeGameJavaFX"