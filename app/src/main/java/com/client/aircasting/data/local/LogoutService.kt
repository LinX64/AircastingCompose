package com.client.aircasting.data.local

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.eventbus.EventBus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import pl.llp.aircasting.events.LogoutEvent
import pl.llp.aircasting.lib.Settings

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
        runBlocking {
            val query = GlobalScope.async(Dispatchers.IO) {
                DatabaseProvider.get().clearAllTables()
            }
            query.await()
        }
    }
}
