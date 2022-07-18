package uz.javokhirdev.photoplay.coreui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun OvalButton(
    @DrawableRes iconRes: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    IconButton(onClick = { onClick() }) {
        Box(
            modifier = modifier
                .size(42.dp)
                .paint(
                    painterResource(id = iconRes),
                    contentScale = ContentScale.Fit
                )
        )
    }
}