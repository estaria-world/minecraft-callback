package world.estaria.minecraft.callback.plugin.paper

import org.bukkit.plugin.java.JavaPlugin
import world.estaria.paper.command.kit.PaperCommandKit

/**
 * @author Niklas Nieberler
 */

class SpigotPlugin : JavaPlugin() {

    override fun onEnable() {
        PaperCommandKit.create(this)
            .parseCommand(CallbackCommand())
    }

}