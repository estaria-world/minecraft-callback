import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

dependencies {
    // minecraft-callback dependencies
    api(project(":callback-api"))

    // limbo dependencies
    compileOnly("com.loohp:Limbo:0.7.7-ALPHA")
    compileOnly("com.github.Querz:NBT:5.5")

    // adventure dependencies
    val adventureVersion = "4.15.0"
    compileOnly("net.kyori:adventure-api:$adventureVersion")
    compileOnly("net.kyori:adventure-text-minimessage:$adventureVersion")
    compileOnly("net.kyori:adventure-text-serializer-gson:$adventureVersion")
    compileOnly("net.kyori:adventure-nbt:$adventureVersion")
}

tasks.named("shadowJar", ShadowJar::class) {
    archiveFileName = "minecraft-callback-limbo-${project.version}.jar"
}