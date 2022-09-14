package screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import data.api.dataSource.VideoDataSource
import data.api.model.Video
import data.api.utils.Response
import di.LocalKoinApplication
import kotlinx.coroutines.launch
import org.koin.core.KoinApplication
import theme.primaryBackground
import theme.primaryText
import theme.secondaryBackground

@Composable
fun MainScreen(
    koinApplication: KoinApplication = LocalKoinApplication.current
) {

    val scope = rememberCoroutineScope()

    val videoDataSource = koinApplication.koin.inject<VideoDataSource>()

    var videos by remember { mutableStateOf<Response<List<Video>>>(Response.Loading()) }

    scope.launch {
        videos = videoDataSource.value.getVideos()
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = primaryBackground
    ){
        LazyColumn {
            when(videos){
                is Response.Error -> item {
                    Text(
                        text = videos.message ?: "Error",
                        fontWeight = FontWeight.W900,
                        color = Color.Red
                    )
                }
                is Response.Loading -> item {
                    CircularProgressIndicator()
                }
                is Response.Success -> videos.data!!.forEach { item ->
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            shape = AbsoluteRoundedCornerShape(15.dp),
                            elevation = 8.dp,
                            backgroundColor = secondaryBackground
                        ) {
                            Text(
                                text = item.title,
                                fontWeight = FontWeight.W900,
                                modifier = Modifier.padding(5.dp),
                                color = primaryText
                            )

                            Divider()
                        }
                    }
                }
            }
        }
    }
}