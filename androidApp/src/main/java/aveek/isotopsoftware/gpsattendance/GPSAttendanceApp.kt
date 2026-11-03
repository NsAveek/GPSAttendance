package aveek.isotopsoftware.gpsattendance

import android.app.Application
import aveek.isotopsoftware.gpsattendance.android.BuildConfig
import aveek.isotopsoftware.gpsattendance.android.di.androidModule
import aveek.isotopsoftware.gpsattendance.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class GPSAttendanceApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(enableNetworkLogs = BuildConfig.DEBUG) {
            androidLogger()
            androidContext(this@GPSAttendanceApp)
            modules(androidModule())
        }
    }
}