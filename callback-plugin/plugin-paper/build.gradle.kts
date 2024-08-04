import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

dependencies {
    // minecraft-callback dependencies
    api(project(":callback-api"))

    // estaria dependencies
    compileOnly("world.estaria:paper-command-kit:1.1.0")

    // paper dependencies
    compileOnly("io.papermc.paper:paper-api:1.21-R0.1-SNAPSHOT")
}

tasks.named("shadowJar", ShadowJar::class) {
    archiveFileName = "minecraft-callback-paper-${project.version}.jar"
}