plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "minecraft-callback"
include("callback-api")
include("callback-plugin")
include("callback-plugin:plugin-limbo")
findProject(":callback-plugin:plugin-limbo")?.name = "plugin-limbo"
include("callback-plugin:plugin-paper")
findProject(":callback-plugin:plugin-paper")?.name = "plugin-paper"
include("callback-plugin:plugin-velocity")
findProject(":callback-plugin:plugin-velocity")?.name = "plugin-velocity"
