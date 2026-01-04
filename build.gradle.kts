plugins {
    id("java")
    id("fabric-loom") version "1.13-SNAPSHOT"
}

val mcVersion = rootProject.providers.gradleProperty("minecraft_version").get()
val build = System.getenv("BUILD_NUMBER")
val gitHash = gitCommit()
val implementationVersion = "$mcVersion-${build ?: "DEV"}-$gitHash"
version = implementationVersion

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

dependencies {
    minecraft("com.mojang:minecraft:1.21.11")
    mappings(loom.officialMojangMappings())
    modImplementation("net.fabricmc:fabric-loader:0.18.4")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.140.2+1.21.11")
    modImplementation("com.terraformersmc:modmenu:17.0.0-beta.1")
//    modImplementation("de.guntram.mcmod:GBfabrictools:1.4+1.20")
//    include("de.guntram.mcmod:GBfabrictools:1.4+1.20")
}

fun gitCommit(): String {
    return ""
    //return "git rev-parse --verify HEAD".execute()
}

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
}