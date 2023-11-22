package aveek.isotopsoftware.gpsattendance.core.model

sealed class ApiResponse<out T> (
    val success : Boolean = false,
    val data : T?,
    val error : ErrorResponse?
)

data class ErrorResponse(
    val message : String
)
