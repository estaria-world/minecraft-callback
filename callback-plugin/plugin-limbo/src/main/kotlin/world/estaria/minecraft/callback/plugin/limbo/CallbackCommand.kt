package world.estaria.minecraft.callback.plugin.limbo

import com.loohp.limbo.commands.CommandExecutor
import com.loohp.limbo.commands.CommandSender
import net.kyori.adventure.text.Component
import world.estaria.minecraft.callback.api.executeCallback

/**
 * @author Niklas Nieberler
 */

class CallbackCommand : CommandExecutor {

    override fun execute(sender: CommandSender, args: Array<out String>) {
        if (!args[0].equals("callback", true) && !sender.hasPermission("callback.command.callback"))
            return

        if (args.isEmpty()) {
            sender.sendMessage(Component.text("<gray>Try again with<dark_gray>:<#dff9fb> /callback (id)"))
            return
        }

        val callbackId = args[1]
        sender.sendMessage(Component.text("<gray>Callback with id <#dff9fb>$callbackId<gray> was executed"))

        val callbackUser = CallbackUserImpl(sender)
        executeCallback(callbackId, callbackUser)
    }

}