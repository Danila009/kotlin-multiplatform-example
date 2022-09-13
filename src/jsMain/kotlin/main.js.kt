import androidx.compose.ui.window.Window
import org.jetbrains.skiko.wasm.onWasmReady
import screen.MainScreen

fun main() {
    onWasmReady {
        Window {
            MainScreen()
        }
    }
}