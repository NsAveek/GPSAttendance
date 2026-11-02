package aveek.isotopsoftware.gpsattendance.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/** Each platform provides its own Ktor engine: OkHttp on Android, Darwin on iOS. */
expect fun httpClientEngine(): HttpClientEngine

/** Holds a single HttpClient for the whole app (registered as a Koin `single`). */
class ApiService(engine: HttpClientEngine = httpClientEngine()) {
    val client: HttpClient = HttpClient(engine) {
        install(HttpTimeout) {
            requestTimeoutMillis = 15_000
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
        install(Logging) {
            level = LogLevel.ALL
            logger = object : Logger {
                override fun log(message: String) {
                    println(message)
                }
            }
        }
    }
}
