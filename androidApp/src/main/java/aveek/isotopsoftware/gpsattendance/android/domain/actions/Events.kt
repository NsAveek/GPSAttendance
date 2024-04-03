package aveek.isotopsoftware.gpsattendance.android.domain.actions

import aveek.isotopsoftware.gpsattendance.data.model.AuthCredentials

sealed class Events {
    data class login(val authCredentials: AuthCredentials) : Events()
    data class register(val authCredentials: AuthCredentials) : Events()
}