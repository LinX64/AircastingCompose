package com.client.aircasting.util.exceptions

import com.client.aircasting.util.Settings

class AircastingUncaughtExceptionHandler internal constructor(val settings: Settings) :
    Thread.UncaughtExceptionHandler {
    private val defaultHandler: Thread.UncaughtExceptionHandler =
        Thread.getDefaultUncaughtExceptionHandler()

    override fun uncaughtException(t: Thread, e: Throwable) {
        // After a crash or user killing the app we want to perform some action in MainActivity.onCreate()
        // so we are saving information about app restart in Settings
        // we need to do this because MainActivity can be destroyed when the app is in the background
        // https://stackoverflow.com/questions/59648644/foreground-service-content-intent-not-resuming-the-app-but-relaunching-it
        settings.setAppRestarted()
        defaultHandler.uncaughtException(t, e)
    }


}
