import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import screen.MainScreen

fun main() = singleWindowApplication(
    title = "KotlinMultiplatformExample",
    state = WindowState(size = DpSize(800.dp, 600.dp))
) {
    MainScreen()
}