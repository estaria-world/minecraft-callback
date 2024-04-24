package world.estaria.minecraft.callback.plugin.limbo

import com.loohp.limbo.plugins.LimboPlugin

/**
 * @author Niklas Nieberler
 */

class LimboPlugin : LimboPlugin() {

    override fun onEnable() {
        server.pluginManager.registerCommands(this, CallbackCommand())
    }

}