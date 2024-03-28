package aveek.isotopsoftware.gpsattendance.domain.model.remote

interface AuthService {
    suspend fun getAccount() : Account?

    companion object {

    }
}