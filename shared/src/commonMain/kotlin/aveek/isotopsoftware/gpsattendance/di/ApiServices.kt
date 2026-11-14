package aveek.isotopsoftware.gpsattendance.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.http.HttpHeaders
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/** Each platform provides its own Ktor engine: OkHttp on Android, Darwin on iOS. */
expect fun httpClientEngine(): HttpClientEngine

/**
 * Holds a single HttpClient for the whole app (registered as a Koin `single`).
 *
 * Network logging is off unless [enableLogging] is true (debug builds only). Even then it logs
 * headers only, never request or response bodies, so passwords and tokens are not printed.
 */
class ApiService(
    engine: HttpClientEngine = httpClientEngine(),
    enableLogging: Boolean = false,
) {
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
        if (enableLogging) {
            install(Logging) {
                level = LogLevel.HEADERS
                sanitizeHeader { header -> header == HttpHeaders.Authorization }
                logger = object : Logger {
                    override fun log(message: String) {
                        println(message)
                    }
                }
            }
        }
    }
}
