package aveek.isotopsoftware.gpsattendance.api

import aveek.isotopsoftware.gpsattendance.data.model.AuthCredentials
import aveek.isotopsoftware.gpsattendance.di.ApiService
import aveek.isotopsoftware.gpsattendance.domain.model.remote.Account
import aveek.isotopsoftware.gpsattendance.domain.model.remote.HttpRoutes.GetAccount
import aveek.isotopsoftware.gpsattendance.domain.repository.AuthRepo
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.util.InternalAPI
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class AuthApi(private val client: ApiService) : AuthRepo {
    // TODO : Have an extension function to generalize exception handling
    // TODO : Add Result class instead of Account
    @OptIn(InternalAPI::class)
    override suspend fun fetchUser(authCredentials: AuthCredentials): Account? {
        val jsonBody = Json.encodeToString(authCredentials)
        return try {
            client.client.post(urlString = GetAccount) {
                contentType(ContentType.Application.Json)
                body = jsonBody
            }.body<Account>()
        } catch (e : RedirectResponseException){
            return null
        } catch (e : ClientRequestException){
            return null
        } catch (e: ServerResponseException){
            return null
        } catch (e : Exception){
            return null
        }
    }
}