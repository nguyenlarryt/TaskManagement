import de.fayard.refreshVersions.core.StabilityLevel.*

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

plugins {
    id("de.fayard.refreshVersions") version "0.40.2"
}

refreshVersions {
    rejectVersionIf {
        candidate.stabilityLevel == Snapshot
    }
}

rootProject.name = "TaskManagement"
include(":app")
