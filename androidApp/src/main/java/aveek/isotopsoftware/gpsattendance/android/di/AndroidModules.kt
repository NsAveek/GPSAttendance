package aveek.isotopsoftware.gpsattendance.android.di

import aveek.isotopsoftware.gpsattendance.android.presentation.viewmodel.AuthenticationViewModel
import aveek.isotopsoftware.gpsattendance.domain.usecases.AuthenticationUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

// Android specific modules
val androidModule = module {
//    single { Greeting() }
//    single { ::GreetPresenter }
    factory { useCasesModule }
    factory { viewModelModule }

}

val useCasesModule = module {
    factory { AuthenticationUseCase(get()) }
}
val viewModelModule = module {
    viewModel <AuthenticationViewModel> { get() }
}
