package aveek.isotopsoftware.gpsattendance.domain.states

import aveek.isotopsoftware.gpsattendance.data.model.AuthCredentials
import aveek.isotopsoftware.gpsattendance.data.model.DEFAULT_PASSWORD
import aveek.isotopsoftware.gpsattendance.data.model.DEFAULT_USERNAME

data class AuthenticationState(
    val credentials: AuthCredentials = AuthCredentials(DEFAULT_USERNAME, DEFAULT_PASSWORD)
)
