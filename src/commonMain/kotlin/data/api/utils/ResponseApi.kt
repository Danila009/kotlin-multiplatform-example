package data.api.utils

import io.ktor.client.call.*
import io.ktor.http.*

abstract class ResponseApi {

    suspend inline fun <reified T> response(
        response: io.ktor.client.statement.HttpResponse
    ): Response<T> {
        return try {
            if (response.status == HttpStatusCode.OK)
                return Response.Success(data = response.body())

            Response.Error(
                "${response.status.value}/${response.status.description}/${response.call.request.url}"
            )
        }catch (e:Exception){
            Response.Error(message = e.message.toString())
        }
    }

}