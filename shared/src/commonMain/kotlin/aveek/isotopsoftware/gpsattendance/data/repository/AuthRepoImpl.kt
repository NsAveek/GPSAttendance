package aveek.isotopsoftware.gpsattendance.data.repository

import aveek.isotopsoftware.gpsattendance.api.AuthApi
import aveek.isotopsoftware.gpsattendance.data.model.AuthCredentials
import aveek.isotopsoftware.gpsattendance.domain.model.remote.Account
import aveek.isotopsoftware.gpsattendance.domain.model.remote.Cats
import aveek.isotopsoftware.gpsattendance.domain.repository.AuthRepo

class AuthRepoImpl (private val api: AuthApi): AuthRepo {
    override suspend fun fetchUser(authCredentials: AuthCredentials): Account? {
        return api.fetchUser(authCredentials)
    }
}