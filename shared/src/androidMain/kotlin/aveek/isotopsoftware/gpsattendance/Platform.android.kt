package aveek.isotopsoftware.gpsattendance

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

//fun init

actual fun getPlatform(): Platform = AndroidPlatform()
//actual fun getSharedModule(): Platform = AndroidPlatform()