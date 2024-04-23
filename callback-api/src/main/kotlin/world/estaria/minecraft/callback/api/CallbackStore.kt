package world.estaria.minecraft.callback.api

/**
 * @author Niklas Nieberler
 */

object CallbackStore {

    private val callbacks = hashMapOf<String, Callback>()

    /**
     * Adds a new callback to the hashmap
     * @param id of the callback
     * @param callback to execute
     */
    fun addCallback(id: String, callback: Callback) {
        callbacks[id] = callback
    }

    /**
     * Executes a callback by an id
     * @param id of the callback
     * @param callbackUser the user to execute this callback
     */
    fun executeCallback(id: String, callbackUser: CallbackUser) {
        callbacks[id]?.execute(callbackUser)
    }

}