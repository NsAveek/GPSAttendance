package aveek.isotopsoftware.gpsattendance.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import aveek.isotopsoftware.gpsattendance.domain.actions.Events
import aveek.isotopsoftware.gpsattendance.domain.states.AuthenticationState
import aveek.isotopsoftware.gpsattendance.domain.usecases.AuthenticationUseCase
import kotlinx.coroutines.launch


open class AuthenticationViewModel ( val authenticationUseCase: AuthenticationUseCase): ViewModel(){

    var authenticationState by mutableStateOf(AuthenticationState())

    init {
//        Log.d("Test Aveek", "VM Testing")
    }

    fun action(events: Events){
        when (events){
            is Events.loginEvent -> {
                viewModelScope.launch {
                    authenticationUseCase.login(authenticationState)
                }
            }
            is Events.registerEvent -> TODO()
        }
    }
    fun check(): String = "Hi"

}