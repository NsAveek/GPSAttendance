package aveek.isotopsoftware.gpsattendance.di

import aveek.isotopsoftware.gpsattendance.PlatformModule
import aveek.isotopsoftware.gpsattendance.api.AuthApi
import aveek.isotopsoftware.gpsattendance.data.repository.AuthRepoImpl
import aveek.isotopsoftware.gpsattendance.domain.repository.AuthRepo
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin{
    appDeclaration()
    modules(appModule())
}
fun appModule() = listOf(commonModule, platformModule, dataSourceModule)

val commonModule = module { /*Add necessary modules*/ }
val platformModule = module {
    single { PlatformModule() }
}
val dataSourceModule = module {
    single { AuthApi(get()) }
    single <AuthRepo> { AuthRepoImpl(get()) }
}