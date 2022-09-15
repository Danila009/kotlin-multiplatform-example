import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import di.LocalKoinApplication
import di.ktorModule
import di.videoApiModule
import navigation.Screen
import navigation.StartNavigation
import org.koin.core.context.startKoin

fun main() = singleWindowApplication(
    title = "Kotlin Multiplatform",
    state = WindowState(size = DpSize(800.dp, 600.dp))
) {


    val koin = startKoin {
        modules(
            videoApiModule,
            ktorModule
        )
    }

    StartNavigation(
        Screen.MainScreen.route,
        LocalKoinApplication provides koin
    )
}