package aveek.isotopsoftware.gpsattendance.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import aveek.isotopsoftware.gpsattendance.domain.actions.AuthEvents
import aveek.isotopsoftware.gpsattendance.domain.states.AuthenticationState
import aveek.isotopsoftware.gpsattendance.domain.usecases.AuthenticationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


open class AuthenticationViewModel ( val authenticationUseCase: AuthenticationUseCase): ViewModel(){

    private val _authenticationState = MutableStateFlow<AuthenticationState>(AuthenticationState.Loading)
    val authenticationState = _authenticationState.asStateFlow()


    val currentState = authenticationState.value

    fun action(events: AuthEvents){
        when (events){
            is AuthEvents.loginEvent -> {
                viewModelScope.launch {
                    _authenticationState.update {
                        AuthenticationState.Loading
                    }
                    val accountResponse = authenticationUseCase.login(events.authCredentials)
                    accountResponse?.let {account ->
                        _authenticationState.update {
                            AuthenticationState.Success(account.email)
                        }
                    } ?: _authenticationState.update {
                        AuthenticationState.Error("Login failed")
                    }
                }
            }
            is AuthEvents.registerEvent -> TODO()
            AuthEvents.forgotPasswordEvent -> TODO()
        }
    }

}