package aveek.isotopsoftware.gpsattendance.domain.usecases

import aveek.isotopsoftware.gpsattendance.data.model.AuthCredentials
import aveek.isotopsoftware.gpsattendance.domain.model.remote.Account
import aveek.isotopsoftware.gpsattendance.domain.repository.AuthRepo

class AuthenticationUseCase ( private val repository: AuthRepo){
    suspend fun login(credentials: AuthCredentials) : Account?{
        return repository.fetchUser(credentials)
    }
    suspend fun register(credentials: AuthCredentials) : Account?{
        return repository.fetchUser(credentials)
    }

}