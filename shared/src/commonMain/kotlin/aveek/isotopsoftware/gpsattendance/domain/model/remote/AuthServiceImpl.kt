package aveek.isotopsoftware.gpsattendance.domain.model.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get

class AuthServiceImpl (private val client : HttpClient): AuthService {
    override suspend fun getAccount(): Account? {
        return try {
            client.get(HttpRoutes.getAccount).body()
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