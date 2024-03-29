package aveek.isotopsoftware.gpsattendance

import platform.UIKit.UIDevice

class IOSPlatform: CommonPlatform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): CommonPlatform = IOSPlatform()