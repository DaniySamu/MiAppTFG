import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.myapptfg.presentation.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "MyAppTFG",
    ) {
        App()
    }
}
