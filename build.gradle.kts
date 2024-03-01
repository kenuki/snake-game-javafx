import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val junit_version: String by properties
val kotlin_version: String by properties

plugins {
    id("java")
    id("application")

    id("org.openjfx.javafxplugin") version ("0.1.0")

    id("org.beryx.jlink") version ("3.0.1")

    kotlin("jvm")
}

group = "dev.kenuki"
version = "0.0.1"
description = "O TEST"

repositories {
    mavenCentral()
}

application {
    mainModule = "dev.kenuki.snakegamejavafx"
    mainClass = "dev.kenuki.snakegamejavafx.Main"
}

javafx {
    version = "17"
    modules = listOf("javafx.controls", "javafx.fxml")
}

dependencies {
    testImplementation(
        group = "org.junit.jupiter",
        name = "junit-jupiter-api",
        version = junit_version,
    )

    testRuntimeOnly(
        group = "org.junit.jupiter",
        name = "junit-jupiter-engine",
        version = junit_version,
    )

    implementation(
        group = "org.jetbrains.kotlin",
        name = "kotlin-stdlib",
        version = kotlin_version,
    )
}

jlink {
    imageZip = project.file("${layout.buildDirectory}/distributions/app-${javafx.platform.classifier}.zip")
    options.addAll(
        listOf(
            "--strip-debug",
            "--compress", "2",
            "--no-header-files",
            "--no-man-pages",
        )
    )

    launcher {
        name = "snake-app"
    }

    jpackage {
        installerName = project.name
        imageName = project.name
        vendor = "TheJustRusik"

        imageOptions.add("--verbose")
        installerOptions = listOf(
            "--verbose",
            "--license-file", "LICENSE",
            "--copyright", "Copyright © 2023 TheJustRusik",

            "--description", "${project.description}",
            "--about-url", "https://github.com/TheJustRusik/snake-game-javafx",
        )

        if (installerType == "msi") {
            installerOptions.addAll(
                listOf(
                    "--win-menu",
                    "--win-menu-group", "CodeDead",
                    "--win-shortcut-prompt",
                    "--win-help-url", "https://github.com/TheJustRusik/snake-game-javafx/issues/",
                    "--win-dir-chooser",
                )
            )
        }

        if (installerType == "deb" || installerType == "rpm") {
            installerOptions.addAll(
                listOf(
                    "--linux-menu-group", "Games",
                    "--linux-shortcut",
                    "--linux-package-name", "snake-game-javafx"
                )
            )
        }

        if (installerType == "rpm") {
            installerOptions.addAll(
                listOf(
                    "--linux-rpm-license-type", "GPLv3"
                )
            )
        }
    }
}

// This is all for Kotlin support in JPMS (modularized Java).
val compileJava: JavaCompile by tasks
val compileKotlin: KotlinCompile by tasks
compileKotlin.destinationDirectory = compileJava.destinationDirectory
tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
// End

tasks {
    withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
    }

    jlinkZip {
        group = "distribution"
    }

    test {
        useJUnitPlatform()
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}
