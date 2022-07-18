package uz.javokhirdev.photoplay.coreui.components

import androidx.compose.foundation.clickable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TextButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Text(
        text = text.uppercase(),
        style = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
        ),
        color = MaterialTheme.colors.onBackground,
        modifier = modifier.clickable { onClick() }
    )
}