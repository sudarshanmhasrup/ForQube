package components.appBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun appBar(modifier: Modifier) {

    Row(
        modifier = modifier,
    ) {
        appBarLogo(
            modifier = Modifier.height(60.dp)
        )
    }
}

@Composable
private fun appBarLogo(modifier: Modifier = Modifier) {

    val logo = painterResource("assets/app-title-bar-logo-light-version.svg")

    Image(
        painter = logo,
        contentDescription = "App bar logo",
        modifier = modifier
    )

}

@Composable
private fun appBarOptions() {

}

