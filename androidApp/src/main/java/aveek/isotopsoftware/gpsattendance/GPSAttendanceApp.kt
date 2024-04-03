package aveek.isotopsoftware.gpsattendance

import android.app.Application
import aveek.isotopsoftware.gpsattendance.di.androidModule
import aveek.isotopsoftware.gpsattendance.di.initKoin
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class GPSAttendanceApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin{
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE )
            androidContext(this@GPSAttendanceApp)
            modules(androidModule)
        }
    }
}