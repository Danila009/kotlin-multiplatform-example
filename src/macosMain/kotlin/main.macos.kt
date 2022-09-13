import androidx.compose.ui.window.Window
import platform.AppKit.NSApp
import platform.AppKit.NSApplication
import screen.MainScreen

fun main() {
    NSApplication.sharedApplication()
    Window("TeslaApp") {
        MainScreen()
    }
    NSApp?.run()
}