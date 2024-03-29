package aveek.isotopsoftware.gpsattendance

import aveek.isotopsoftware.gpsattendance.di.ApiService
import org.koin.core.module.Module
import org.koin.dsl.module

actual class PlatformModule actual constructor() {
    actual fun platformModule() = module {
        single{ ApiService() }
    }
}