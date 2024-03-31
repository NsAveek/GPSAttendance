package aveek.isotopsoftware.gpsattendance.data.model

import kotlinx.serialization.Serializable

@Serializable
data class AuthCredentials(
    @Serializable val username : String, @Serializable val password : String)
