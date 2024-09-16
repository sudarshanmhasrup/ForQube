package view.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.WindowState

private val windowWidth = 680.dp
private val windowHeight = 480.dp

@Composable
fun splashScreen(modifier: Modifier = Modifier) {

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
        )
    ) {
        Surface(
            modifier = modifier,
            shape = RoundedCornerShape(8.dp),
            color = Color.Transparent
        ) {
            Box(
                modifier = modifier
            ) {
                backgroundImage(
                    modifier = modifier
                )
                Column(
                    modifier = modifier
                ) {
                    splashScreenLogo(
                        modifier = Modifier.weight(1f)
                            .fillMaxWidth()
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
        modifier = modifier
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

