package world.estaria.minecraft.callback.plugin.limbo

import com.loohp.limbo.commands.CommandSender
import world.estaria.minecraft.callback.api.CallbackUser

/**
 * @author Niklas Nieberler
 */

class CallbackUserImpl(
    private val commandSender: CommandSender
) : CallbackUser {

    override fun getName(): String {
        return this.commandSender.name
    }

    override fun sendMessage(message: String) {
        this.commandSender.sendMessage(message)
    }

}