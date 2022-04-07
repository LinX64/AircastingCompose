package com.client.aircasting.data.local

import com.client.aircasting.util.Settings
import com.client.aircasting.util.events.LogoutEvent
import org.greenrobot.eventbus.EventBus

class LogoutService(private val mSettings: Settings) {
    fun perform(callback: (() -> Unit)? = null) {
        // to make sure downloading sessions stopped before we start deleting them
        EventBus.getDefault().post(LogoutEvent())
        mSettings.logout()
        clearDatabase()
        callback?.invoke()
    }

    private fun clearDatabase() {
        Thread.sleep(1000)
        /*runBlocking {
            val query = GlobalScope.async(Dispatchers.IO) {
                DatabaseProvider.get().clearAllTables()
            }
            query.await()
        }*/
    }
}
