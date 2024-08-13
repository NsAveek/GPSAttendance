package aveek.isotopsoftware.gpsattendance.domain.states

import aveek.isotopsoftware.gpsattendance.data.model.AuthCredentials

sealed interface AuthenticationState{
    data class Success<T> (val account : T ): AuthenticationState
    data class Error<T>(val exception: T): AuthenticationState
    object Loading : AuthenticationState
}