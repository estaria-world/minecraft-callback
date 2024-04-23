package world.estaria.minecraft.callback.api

/**
 * @author Niklas Nieberler
 */

interface CallbackUser {

    /**
     * Gets the name of this user
     * @return name of this user
     */
    fun getName(): String

    /**
     * Sends a message to this user
     * @param message to send
     */
    fun sendMessage(message: String)

}