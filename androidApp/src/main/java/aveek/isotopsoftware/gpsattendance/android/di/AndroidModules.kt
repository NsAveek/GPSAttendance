package aveek.isotopsoftware.gpsattendance.android.di

import aveek.isotopsoftware.gpsattendance.domain.usecases.AuthenticationUseCase
import aveek.isotopsoftware.gpsattendance.viewmodel.AuthenticationViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


// Android specific modules
fun androidModule () = listOf(useCasesModule, viewModelModule)
val useCasesModule = module {
    factory { AuthenticationUseCase(get()) }
}

val viewModelModule = module {
    viewModelOf(::AuthenticationViewModel)
}
