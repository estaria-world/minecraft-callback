package world.estaria.minecraft.callback.api

/**
 * @author Niklas Nieberler
 */

fun interface Callback {

    /**
     * This method is executed when the callback is executed
     * @param callbackUser the user who carried out this callback
     */
    fun execute(callbackUser: CallbackUser)

}