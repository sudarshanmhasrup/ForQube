package view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import components.appBar.appBar
import view.homeScreen.homeScreen
import view.splashScreen.splashScreen
import java.awt.Toolkit
import kotlin.system.exitProcess

// Window height and width
private val toolkit = Toolkit.getDefaultToolkit().screenSize
private val windowWidth = toolkit.width.dp
private val windowHeight = toolkit.height.dp

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

    // Adjust window size to leave space for the taskbar
    val windowState = rememberWindowState(
        position = WindowPosition(Alignment.Center),
        size = DpSize(windowWidth, windowHeight - 40.dp)
    )

    Window(
        onCloseRequest = { exitProcess(0) },
        icon = windowIcon,
        undecorated = true,
        state = windowState
    ) {
        Column {
            appBar(
                modifier = Modifier.fillMaxWidth()
            )
            homeScreen(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
