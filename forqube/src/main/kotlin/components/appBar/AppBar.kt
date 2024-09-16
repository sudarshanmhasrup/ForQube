package components.appBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.pointerMoveFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import theme.closeButtonHoverColor
import kotlin.system.exitProcess

@Composable
fun appBar(modifier: Modifier = Modifier) {

    Row(
        modifier = modifier.height(IntrinsicSize.Max),
    ) {
        appBarLogo(
            modifier = Modifier.height(20.dp)
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        appBarOptions(
            modifier = Modifier.fillMaxHeight()
        )
    }
}

@Composable
private fun appBarLogo(modifier: Modifier = Modifier) {

    val logo = painterResource("assets/app-title-bar-logo-light-version.svg")

    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        Image(
            painter = logo,
            contentDescription = "App bar logo",
            modifier = modifier,
        )
    }

}

@Composable
private fun appBarOptions(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
    ) {
        closeButtonWithIcon(
            modifier = modifier.width(40.dp)
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun closeButtonWithIcon(modifier: Modifier = Modifier) {

    var isHovered by remember { mutableStateOf(false) }

    val icon = if (isHovered) {
        painterResource("assets/close-button-dark.svg")
    } else {
        painterResource("assets/close-button-light.svg")
    }

    val backgroundColor = if (isHovered) {
        closeButtonHoverColor
    } else {
        Color.Transparent
    }

    Column (
        modifier = modifier.background(backgroundColor)
            .pointerMoveFilter(
            onEnter = {
                isHovered = true
                true
            },
            onExit = {
                isHovered = false
                true
            }
        )
            .clickable {
            exitProcess(0)
        },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = icon,
            contentDescription = "Close window icon.",
            modifier = Modifier.height(8.dp)
        )
    }
}
