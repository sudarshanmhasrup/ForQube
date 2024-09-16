import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.application
import view.splashScreen.initApp
import view.splashScreen.splashScreen

// The main function
fun main() = application {
    initApp(
        modifier = Modifier.fillMaxSize()
    )
}