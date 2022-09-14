import androidx.compose.ui.window.Window
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
    onWasmReady {
        Window(
            title = "Kotlin multiplatform"
        ) {
            val mainApp = MainApp()

            mainApp.StartApp()
        }
    }
}