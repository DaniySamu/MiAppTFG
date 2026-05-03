import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.example.myapptfg.presentation.App

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(title = "MyAppTFG", canvasElementId = "compose-target") {
        App()
    }
}
