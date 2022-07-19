package uz.javokhirdev.photoplay.coreui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.javokhirdev.photoplay.core.R

@Composable
fun BigImageLogo() {
    Image(
        painter = painterResource(R.drawable.logo),
        contentDescription = "Logo",
        modifier = Modifier.height(160.dp)
    )
}