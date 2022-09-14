package di

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val ktorModule = module {

    single {
        Json {
            ignoreUnknownKeys = true
            explicitNulls = false
        }
    }

    single {
        HttpClient() {
            install(ContentNegotiation){
                json(get())
            }

            defaultRequest {
                url {
                    val basePath = "/youTube/api/"
                    protocol = URLProtocol.HTTPS
                    host = "api.cfif31.ru"
                    encodedPath = "$basePath$encodedPath"
                }
            }
        }
    }
}