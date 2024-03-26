package aveek.isotopsoftware.gpsattendance

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GPSAttendanceApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@GPSAttendanceApp)
        }
    }
}