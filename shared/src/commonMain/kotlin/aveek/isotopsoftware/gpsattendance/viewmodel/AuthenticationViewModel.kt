package aveek.isotopsoftware.gpsattendance.viewmodel

import androidx.lifecycle.ViewModel
import aveek.isotopsoftware.gpsattendance.domain.usecases.AuthenticationUseCase
import org.koin.core.component.KoinComponent

class AuthenticationViewModel (val authenticationUseCase : AuthenticationUseCase) : ViewModel(), KoinComponent {

    init {
//        Log.d("Test Aveek", "VM Testing")
    }

    fun check(): String = "Hi"

}