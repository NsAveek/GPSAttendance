package aveek.isotopsoftware.gpsattendance.data.model

import kotlinx.serialization.Serializable

internal const val DEFAULT_USERNAME = ""
internal const val DEFAULT_PASSWORD = ""
@Serializable
data class AuthCredentials(
    @Serializable val username : String, @Serializable val password : String)
