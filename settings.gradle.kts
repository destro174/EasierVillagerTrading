rootProject.name = "EasierVillagerTradingReloaded"

pluginManagement {
    repositories {
        maven {
            name = "Fabric"
            url = uri("https://maven.fabricmc.net/")
        }
        maven {
            url = uri("https://maven.shedaniel.me/")
        }
        maven {
            url = uri("https://maven.terraformersmc.com/")
        }
        maven {
            url = uri("https://minecraft.guntram.de/maven/")
        }
        mavenCentral()
        gradlePluginPortal()
        mavenCentral()
        gradlePluginPortal()
    }

    plugins {
        id("net.fabricmc.fabric-loom") version providers.gradleProperty("loom_version")
    }
}