package aveek.isotopsoftware.gpsattendance

import aveek.isotopsoftware.gpsattendance.di.initKoin

/**
 * Called from Swift as `KoinIosKt.doInitKoinIos(enableNetworkLogs:)` when the iOS app starts.
 * Pass true only in DEBUG builds.
 */
fun initKoinIos(enableNetworkLogs: Boolean) {
    initKoin(enableNetworkLogs = enableNetworkLogs)
}
