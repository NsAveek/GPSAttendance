package aveek.isotopsoftware.gpsattendance.domain.model.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val id: Int,
    val username: String,
    @SerialName("email") val email: String,
    @SerialName("firstName") val firstName: String,
    @SerialName("lastName")  val lastName: String,
    @SerialName("gender") val gender: String,
    @SerialName("image") val image: String,
    @SerialName("token") val token: String
)

@Serializable
data class Cats(
    val id : String,
    val url: String,
    val width : Int,
    val height : Int
)