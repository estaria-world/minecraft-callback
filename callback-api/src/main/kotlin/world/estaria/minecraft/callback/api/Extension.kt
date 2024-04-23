package world.estaria.minecraft.callback.api

import world.estaria.minecraft.callback.api.Callback
import world.estaria.minecraft.callback.api.CallbackStore
import world.estaria.minecraft.callback.api.CallbackUser
import java.util.*

/**
 * @author Niklas Nieberler
 */

/**
 * Creates a new callback with a random id
 * @param callback to execute
 */
fun callback(callback: Callback) {
    CallbackStore.addCallback(UUID.randomUUID().toString(), callback)
}

/**
 * Creates a new callback
 * @param id for this callback
 * @param callback to execute
 */
fun callback(id: String, callback: Callback) {
    CallbackStore.addCallback(id, callback)
}

/**
 * Executes a callback by an id
 * @param id of the callback
 * @param callbackUser the user to execute this callback
 */
fun executeCallback(id: String, callbackUser: CallbackUser) {
    CallbackStore.executeCallback(id, callbackUser)
}