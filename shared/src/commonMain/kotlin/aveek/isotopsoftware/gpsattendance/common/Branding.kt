package aveek.isotopsoftware.gpsattendance.common

data class GPSAttendanceThemeTypography(
    val fontFamily: String, // Use only on Android
    val fontFamilyName: String, // Use only on iOS
    val fontWeight: FontWeight,
    val fontSize: Int,
    val lineHeight: Int,
    val letterSpacing: Int = 0 // TBD and thus for now it is 0.
)