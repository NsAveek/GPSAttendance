package aveek.isotopsoftware.gpsattendance.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLBuilder
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

actual class ApiService actual constructor() {
    actual fun build(): HttpClient {
        return HttpClient{
            defaultRequest {
                url.takeFrom(URLBuilder().takeFrom(""))
            }
            install(HttpTimeout){
                requestTimeoutMillis = 15_000
            }
            install(ContentNegotiation){
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                })
            }
            install(Logging){
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        println(message)
                    }
                }
            }
        }
    }
}