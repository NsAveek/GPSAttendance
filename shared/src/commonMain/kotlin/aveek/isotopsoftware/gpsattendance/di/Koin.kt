package aveek.isotopsoftware.gpsattendance.di

import aveek.isotopsoftware.gpsattendance.api.AuthApi
import aveek.isotopsoftware.gpsattendance.data.repository.AuthRepoImpl
import aveek.isotopsoftware.gpsattendance.domain.repository.AuthRepo
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

/**
 * Starts Koin with the shared modules.
 * @param enableNetworkLogs pass true only in debug builds.
 */
fun initKoin(
    enableNetworkLogs: Boolean = false,
    appDeclaration: KoinAppDeclaration = {},
) = org.koin.core.context.startKoin {
    appDeclaration()
    modules(appModule(enableNetworkLogs))
}

fun appModule(enableNetworkLogs: Boolean = false) =
    listOf(commonModule, dataSourceModule(enableNetworkLogs))

val commonModule = module { /*Add necessary modules*/ }
fun dataSourceModule(enableNetworkLogs: Boolean) = module {
    single { ApiService(enableLogging = enableNetworkLogs) }
    single { AuthApi(get()) }
    single<AuthRepo> { AuthRepoImpl(get()) }
}
