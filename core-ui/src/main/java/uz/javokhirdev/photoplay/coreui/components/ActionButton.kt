package uz.javokhirdev.photoplay.coreui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uz.javokhirdev.photoplay.coreui.AppPrimary
import uz.javokhirdev.photoplay.coreui.AppSecondary

@Composable
fun ActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        enabled = isEnabled,
        shape = MaterialTheme.shapes.medium
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(brush = Brush.verticalGradient(listOf(AppPrimary, AppSecondary)))
                .padding(
                    vertical = 14.dp,
                    horizontal = 16.dp
                )
                .then(modifier),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = text.uppercase(),
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}