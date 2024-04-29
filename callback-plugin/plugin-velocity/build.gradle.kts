import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

dependencies {
    // minecraft-callback dependencies
    api(project(":callback-api"))

    // velocity dependencies
    compileOnly("com.velocitypowered:velocity-api:3.3.0-SNAPSHOT")
    annotationProcessor("com.velocitypowered:velocity-api:3.3.0-SNAPSHOT")
}

tasks.named("shadowJar", ShadowJar::class) {
    archiveFileName = "minecraft-callback-velocity-${project.version}.jar"
}