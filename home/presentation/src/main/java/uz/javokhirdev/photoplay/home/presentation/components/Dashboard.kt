package uz.javokhirdev.photoplay.home.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import uz.javokhirdev.photoplay.coreui.Gray

@Composable
fun getIconTint(selected: Boolean): State<Color> {
    return animateColorAsState(if (selected) MaterialTheme.colors.primary else Gray)
}