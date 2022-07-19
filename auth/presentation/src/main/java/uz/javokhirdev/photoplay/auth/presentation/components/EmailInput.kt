package uz.javokhirdev.photoplay.auth.presentation.components

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.javokhirdev.photoplay.core.R
import uz.javokhirdev.photoplay.coreui.Gray
import uz.javokhirdev.photoplay.coreui.LocalSpacing

@Composable
fun EmailInput(
    modifier: Modifier = Modifier,
    email: String,
    onEmailChanged: (String) -> Unit
) {
    val spacing = LocalSpacing.current

    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.email).uppercase(),
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        Box(modifier = Modifier.fillMaxWidth()) {
            BasicTextField(
                value = email,
                onValueChange = onEmailChanged,
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .shadow(
                        elevation = 2.dp,
                        shape = MaterialTheme.shapes.medium
                    )
                    .background(MaterialTheme.colors.surface)
                    .fillMaxWidth()
                    .padding(
                        vertical = 12.dp,
                        horizontal = 16.dp
                    ),
                textStyle = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onBackground
                )
            )
            androidx.compose.animation.AnimatedVisibility(
                visible = email.isEmpty(),
                enter = fadeIn(animationSpec = tween(200)),
                exit = fadeOut(animationSpec = tween(200)),
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Text(
                    text = stringResource(id = R.string.email_hint),
                    style = MaterialTheme.typography.body1,
                    color = Gray,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}