package aveek.isotopsoftware.gpsattendance.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import aveek.isotopsoftware.gpsattendance.domain.actions.AuthEvents
import aveek.isotopsoftware.gpsattendance.domain.states.AuthenticationState
import aveek.isotopsoftware.gpsattendance.domain.usecases.AuthenticationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


open class AuthenticationViewModel ( val authenticationUseCase: AuthenticationUseCase): ViewModel(){

    private val _authenticationState =  MutableStateFlow(AuthenticationState())
    val authenticationState = _authenticationState.asStateFlow()


    val currentState = authenticationState.value
    init {
//        Log.d("Test Aveek", "VM Testing")
    }

    fun action(events: AuthEvents){
        when (events){
            is AuthEvents.loginEvent -> {
                viewModelScope.launch {
                    val accountResponse = authenticationUseCase.login(events.authCredentials)
                    val email = accountResponse?.let {
                        accountResponse.email
                    }?: {"none@none.com"}
                }
            }
            is AuthEvents.registerEvent -> TODO()
        }
    }
    fun check(): String = "Hi"

}