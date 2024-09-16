package view.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

private val windowWidth = 680.dp
private val windowHeight = 480.dp

@Composable
fun splashScreen(modifier: Modifier = Modifier) {

    val windowIcon = painterResource("assets/launcher-icon.png")

    // Splash screen window
    Window(
        onCloseRequest = {},
        transparent = true,
        resizable = false,
        undecorated = true,
        state = WindowState(
            width = windowWidth,
            height = windowHeight,
            position = WindowPosition(Alignment.Center)
        ),
        icon = windowIcon
    ) {
        Surface(
            modifier = modifier,
            shape = RoundedCornerShape(8.dp),
            color = Color.Transparent
        ) {
            Box(
                modifier = modifier
            ) {
                background(
                    modifier = modifier
                )
                Column(
                    modifier = modifier
                ) {
                    splashScreenLogo(
                        modifier = Modifier.weight(1f)
                            .fillMaxWidth()
                    )
                    splashScreenProgressBar(
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun backgroundImage(modifier: Modifier = Modifier) {

    val backgroundImage = painterResource("assets/splash-screen-background.png")

    Image(
        painter = backgroundImage,
        contentDescription = "Splash screen background image.",
        modifier = modifier,
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun background(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        color = Color.Black,
        content = {}
    )
}

@Composable
fun splashScreenLogo(modifier: Modifier = Modifier) {

    val splashScreenLogo = painterResource("assets/splash-screen-logo.svg")

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = splashScreenLogo,
            contentDescription = "Splash screen logo.",
            modifier = Modifier.height(80.dp)
        )
    }
}

@Composable
fun splashScreenProgressBar(modifier: Modifier = Modifier) {

    var currentProgress by remember { mutableStateOf(0.0f) }

    LinearProgressIndicator(
        progress = currentProgress,
        color = Color.White,
        backgroundColor = Color.Transparent,
        modifier = modifier.height(4.dp)
    )

    LaunchedEffect(Unit) {
        coroutineScope {
            for (i in 1 .. 10) {
                currentProgress += 0.1f
                delay(40)
            }
        }
    }
}
