plugins {
    id("java")
    id("net.fabricmc.fabric-loom")
}

val mcVersion = providers.gradleProperty("minecraft_version").get()
//val build = System.getenv("BUILD_NUMBER")
val build = 0
val gitHash = gitCommit()
val implementationVersion = "$mcVersion-${build ?: "DEV"}-$gitHash"
version = implementationVersion

dependencies {
    minecraft("com.mojang:minecraft:${providers.gradleProperty("minecraft_version").get()}")
    implementation("net.fabricmc:fabric-loader:${providers.gradleProperty("loader_version").get()}")
    implementation("net.fabricmc.fabric-api:fabric-api:${providers.gradleProperty("fabric_api_version").get()}")
//    modImplementation("com.terraformersmc:modmenu:20.0.0-beta.4")
//    modImplementation("de.guntram.mcmod:GBfabrictools:1.4+1.20")
//    include("de.guntram.mcmod:GBfabrictools:1.4+1.20")
}

loom {
//    mappings(loom.officialMojangMappings())
}

fun gitCommit(): String {
    return ""
    //return "git rev-parse --verify HEAD".execute()
}