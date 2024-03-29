package aveek.isotopsoftware.gpsattendance

import aveek.isotopsoftware.gpsattendance.di.appModule
import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(appModule())
    }
}