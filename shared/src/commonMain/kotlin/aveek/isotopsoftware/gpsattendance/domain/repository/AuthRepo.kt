package aveek.isotopsoftware.gpsattendance.domain.repository

import aveek.isotopsoftware.gpsattendance.data.model.AuthCredentials
import aveek.isotopsoftware.gpsattendance.domain.model.remote.Account

interface AuthRepo {
    suspend fun fetchUser(authCredentials: AuthCredentials) : Account
}