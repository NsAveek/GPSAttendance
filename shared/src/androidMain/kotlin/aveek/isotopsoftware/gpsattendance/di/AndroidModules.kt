package aveek.isotopsoftware.gpsattendance.di

import aveek.isotopsoftware.gpsattendance.domain.usecases.AuthenticationUseCase
import aveek.isotopsoftware.gpsattendance.viewmodel.AuthenticationViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

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
    viewModel<AuthenticationViewModel> { get() }
//    viewModel<AuthenticationViewModel>()
//    viewModel<AuthenticationViewModel>{ get() }
}
