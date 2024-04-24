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
        this.callbacks[id] = callback
    }

    /**
     * Gets a list of all callback ids
     * @return callback id list
     */
    fun getCallbackIds(): List<String> {
        return this.callbacks.keys.toList()
    }

    /**
     * Executes a callback by an id
     * @param id of the callback
     * @param callbackUser the user to execute this callback
     */
    fun executeCallback(id: String, callbackUser: CallbackUser) {
        this.callbacks[id]?.execute(callbackUser)
    }

}