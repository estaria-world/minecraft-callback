package world.estaria.minecraft.callback.plugin.paper

import net.kyori.adventure.text.Component
import org.bukkit.command.CommandSender
import org.incendo.cloud.annotations.Argument
import org.incendo.cloud.annotations.Command
import org.incendo.cloud.annotations.Permission
import org.incendo.cloud.annotations.suggestion.Suggestions
import world.estaria.minecraft.callback.api.CallbackStore
import world.estaria.minecraft.callback.api.executeCallback

/**
 * @author Niklas Nieberler
 */

class CallbackCommand {

    @Command("callback <id>")
    @Permission("callback.command.callback")
    fun execute(sender: CommandSender, @Argument("id", suggestions = "callbackIds") id: String) {
        sender.sendMessage(Component.text("<gray>Callback with id <#dff9fb>$id<gray> was executed"))

        val callbackUser = CallbackUserImpl(sender)
        executeCallback(id, callbackUser)
    }

    @Suggestions("callbackIds")
    fun suggestCallbackId(): List<String> {
        return CallbackStore.getCallbackIds()
    }

}