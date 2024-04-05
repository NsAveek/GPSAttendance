package aveek.isotopsoftware.gpsattendance.domain.actions

import aveek.isotopsoftware.gpsattendance.data.model.AuthCredentials

sealed class AuthEvents {
    data class loginEvent(val authCredentials: AuthCredentials) : AuthEvents()
    data class registerEvent(val authCredentials: AuthCredentials) : AuthEvents()
}