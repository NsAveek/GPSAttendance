package aveek.isotopsoftware.gpsattendance.android.presentation.util

sealed class Screens(val route: String) {
    object LoginScreen : Screens("login_screen")
    object RegistrationScreen : Screens("registration_screen")

    fun withArgs(vararg args : String) : String {
        return buildString {
            append(route)
            args.forEach {arg ->
                append("/$arg")
            }
        }
    }
}
