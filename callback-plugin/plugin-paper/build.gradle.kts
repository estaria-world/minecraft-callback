dependencies {
    // minecraft-callback dependencies
    api(project(":callback-api"))

    // estaria dependencies
    compileOnly("world.estaria:paper-command-kit:1.0.2")

    // paper dependencies
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
}