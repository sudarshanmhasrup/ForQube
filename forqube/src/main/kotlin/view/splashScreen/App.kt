package view.splashScreen

import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import components.appBar.appBar
import org.jetbrains.skia.Surface
import java.awt.Toolkit
import javax.swing.JFrame
import kotlin.system.exitProcess


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

    Window(
        onCloseRequest = { exitProcess(0) },
        icon = windowIcon
    ) {
        appBar(
            modifier = Modifier.fillMaxWidth()
        )
    }

}