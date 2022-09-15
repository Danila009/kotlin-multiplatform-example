import androidx.compose.ui.window.Window
import di.LocalKoinApplication
import di.ktorModule
import di.videoApiModule
import navigation.Screen
import navigation.StartNavigation
import org.jetbrains.skiko.wasm.onWasmReady
import org.koin.core.context.startKoin

fun main() {

    val koin = startKoin {
        modules(
            videoApiModule,
            ktorModule
        )
    }

    onWasmReady {
        Window(
            title = "Kotlin multiplatform"
        ) {
            StartNavigation(
                startScreen = Screen.MainScreen.route,
                LocalKoinApplication provides koin
            )
        }
    }
}