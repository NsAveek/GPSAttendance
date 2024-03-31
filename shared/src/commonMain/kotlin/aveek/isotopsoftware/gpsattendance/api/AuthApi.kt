package aveek.isotopsoftware.gpsattendance.api

import aveek.isotopsoftware.gpsattendance.data.model.AuthCredentials
import aveek.isotopsoftware.gpsattendance.di.ApiService
import aveek.isotopsoftware.gpsattendance.domain.model.remote.Account
import aveek.isotopsoftware.gpsattendance.domain.model.remote.Cats
import aveek.isotopsoftware.gpsattendance.domain.model.remote.HttpRoutes.GetAccount
import aveek.isotopsoftware.gpsattendance.domain.repository.AuthRepo
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.Parameters
import io.ktor.http.contentType
import io.ktor.util.InternalAPI
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class AuthApi(private val client: ApiService) : AuthRepo {
    @OptIn(InternalAPI::class)
    override suspend fun fetchUser(authCredentials: AuthCredentials): Account? {
        val jsonBody = Json.encodeToString(authCredentials)
        return try {
            client.client.post(urlString = GetAccount) {
                contentType(ContentType.Application.Json)
                body = jsonBody
            }.body<Account>()
        } catch (e: Exception) {
            // TODO : Catch exception
            return null
        }
    }
}