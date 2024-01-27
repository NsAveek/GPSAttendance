package aveek.isotopsoftware.gpsattendance.domain.model.remote

data class Account(
    val email: String,
    val firstName: String,
    val gender: String,
    val id: Int,
    val image: String,
    val lastName: String,
    val token: String,
    val username: String
)