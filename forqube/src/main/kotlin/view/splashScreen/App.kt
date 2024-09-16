package view.splashScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import components.appBar.appBar
import kotlin.system.exitProcess

@Composable
fun initApp(modifier: Modifier = Modifier) {

    var showSplashScreen by remember { mutableStateOf(true) }

    if (showSplashScreen) {
        splashScreen(
            modifier = modifier,
            onFinished = { showSplashScreen = false}
        )
    } else {
        appWindow()
    }
}

@Composable
private fun appWindow() {

    val windowIcon = painterResource("assets/launcher-icon.png")

    Window(
        onCloseRequest = { exitProcess(0) },
        state = WindowState(
            placement = WindowPlacement.Maximized
        ),
        icon = windowIcon
    ) {
        appBar(
            modifier = Modifier.fillMaxWidth()
        )
    }
}