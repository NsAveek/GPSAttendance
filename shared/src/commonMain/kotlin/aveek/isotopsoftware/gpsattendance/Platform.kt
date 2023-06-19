package aveek.isotopsoftware.gpsattendance

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform