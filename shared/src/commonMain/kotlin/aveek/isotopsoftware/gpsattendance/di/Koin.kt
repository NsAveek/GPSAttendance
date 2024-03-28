package aveek.isotopsoftware.gpsattendance.di

import org.koin.core.context.startKoin

fun initiateKoin() = startKoin{
    modules(platformModule())
}