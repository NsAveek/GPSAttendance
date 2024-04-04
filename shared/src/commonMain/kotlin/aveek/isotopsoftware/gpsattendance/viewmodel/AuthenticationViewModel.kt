package aveek.isotopsoftware.gpsattendance.viewmodel

import androidx.lifecycle.ViewModel
import aveek.isotopsoftware.gpsattendance.domain.usecases.AuthenticationUseCase


open class AuthenticationViewModel (authenticationUseCase: AuthenticationUseCase): ViewModel(){

    init {
//        Log.d("Test Aveek", "VM Testing")
    }

    fun check(): String = "Hi"

}