package data.api.dataSource

import data.api.model.Video
import data.api.utils.Response
import data.api.utils.ResponseApi
import io.ktor.client.*
import io.ktor.client.request.*

class VideoDataSource(
    private val httpClient: HttpClient
):ResponseApi() {

    suspend fun getVideos():Response<List<Video>> {
       return response(httpClient.get(BASE_PATH + VIDEO_URL))
    }

    companion object {
        const val BASE_PATH = "/youTube/api"

        const val VIDEO_URL = "/video"
    }

}