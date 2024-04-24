package world.estaria.minecraft.callback.plugin.velocity

import com.velocitypowered.api.command.CommandSource
import net.kyori.adventure.text.Component
import world.estaria.minecraft.callback.api.CallbackUser
import java.util.UUID

/**
 * @author Niklas Nieberler
 */

class CallbackUserImpl(
    private val commandSource: CommandSource
) : CallbackUser {
    override fun getName(): String {
        return UUID.randomUUID().toString()
    }

    override fun sendMessage(message: String) {
        this.commandSource.sendMessage(Component.text(message))
    }
}