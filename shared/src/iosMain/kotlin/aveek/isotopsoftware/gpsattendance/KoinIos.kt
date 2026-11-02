package aveek.isotopsoftware.gpsattendance

import aveek.isotopsoftware.gpsattendance.di.initKoin

/** Called from Swift as `KoinIosKt.doInitKoinIos()` when the iOS app starts. */
fun initKoinIos() {
    initKoin()
}
