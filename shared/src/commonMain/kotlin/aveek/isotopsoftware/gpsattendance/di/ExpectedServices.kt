package aveek.isotopsoftware.gpsattendance.di

import io.ktor.client.HttpClient

expect class ApiService(){
    fun build () : HttpClient

}