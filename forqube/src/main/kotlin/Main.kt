import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.application
import view.initApp

// The main function
fun main() = application {
    initApp(
        modifier = Modifier.fillMaxSize()
    )
}