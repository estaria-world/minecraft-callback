package world.estaria.minecraft.callback.plugin.velocity

import com.google.inject.Inject
import com.mojang.brigadier.arguments.StringArgumentType
import com.velocitypowered.api.command.BrigadierCommand
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.proxy.ProxyServer
import net.kyori.adventure.text.Component
import world.estaria.minecraft.callback.api.CallbackStore
import world.estaria.minecraft.callback.api.executeCallback


/**
 * @author Niklas Nieberler
 */

@Plugin(id = "minecraft-callback", name = "minecraft-callback", version = "1.0.1", authors = ["MrManHD"])
class VelocityPlugin @Inject constructor(
    private val server: ProxyServer,
) {

    @Subscribe
    fun handleInitialize(event: ProxyInitializeEvent) {
        val commandManager = server.commandManager
        val commandMeta = commandManager.metaBuilder("velocityCallback")
            .plugin(this)
            .build()
        val brigadierCommand = createBrigadierCommand()
        commandManager.register(commandMeta, brigadierCommand)
    }

    private fun createBrigadierCommand(): BrigadierCommand {
        val commandNode = BrigadierCommand.literalArgumentBuilder("velocityCallback")
            .requires { it.hasPermission("callback.command.callback") }
            .executes {
                it.source.sendMessage(Component.text("<gray>Try again with<dark_gray>:<#dff9fb> /callback (id)"))
                return@executes 1
            }
            .then(BrigadierCommand.requiredArgumentBuilder("callbackId", StringArgumentType.string())
                .suggests { _, builder ->
                    CallbackStore.getCallbackIds().forEach { builder.suggest(it) }
                    builder.buildFuture()
                }
                .executes {
                    val commandSource = it.source
                    val callbackId = it.getArgument("callbackId", String::class.java)
                    commandSource.sendMessage(Component.text("<gray>Callback with id <#dff9fb>$callbackId was executed"))

                    val callbackUser = CallbackUserImpl(commandSource)
                    executeCallback(callbackId, callbackUser)
                    return@executes 1
                }
            )
            .build()
        return BrigadierCommand(commandNode)
    }

}