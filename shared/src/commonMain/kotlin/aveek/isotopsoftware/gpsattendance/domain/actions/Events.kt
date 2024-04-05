package aveek.isotopsoftware.gpsattendance.domain.actions

import aveek.isotopsoftware.gpsattendance.data.model.AuthCredentials

sealed class Events {
    data class loginEvent(val authCredentials: AuthCredentials) : Events()
    data class registerEvent(val authCredentials: AuthCredentials) : Events()
}