import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import di.LocalKoinApplication
import di.ktorModule
import di.videoApiModule
import org.koin.core.context.startKoin
import screen.MainScreen

class MainApp {

    private val koin = startKoin {
        modules(
            videoApiModule,
            ktorModule
        )
    }

    @Composable
    fun StartApp() {
        CompositionLocalProvider(
            LocalKoinApplication provides koin
        ){
            MainScreen()
        }
    }
}