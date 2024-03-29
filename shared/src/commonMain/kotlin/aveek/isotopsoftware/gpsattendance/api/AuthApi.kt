package aveek.isotopsoftware.gpsattendance.api

import aveek.isotopsoftware.gpsattendance.data.model.AuthCredentials
import aveek.isotopsoftware.gpsattendance.domain.model.remote.Account
import aveek.isotopsoftware.gpsattendance.domain.model.remote.HttpRoutes.GetAccount
import aveek.isotopsoftware.gpsattendance.domain.repository.AuthRepo
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class AuthApi ( private val client: HttpClient) : AuthRepo {
    override suspend fun fetchUser(authCredentials : AuthCredentials): Account {
       return client.get(urlString = GetAccount).body<Account>()
    }
}