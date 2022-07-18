package uz.javokhirdev.photoplay.auth.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import uz.javokhirdev.photoplay.auth.presentation.components.EmailInput
import uz.javokhirdev.photoplay.auth.presentation.components.PasswordInput
import uz.javokhirdev.photoplay.core.R
import uz.javokhirdev.photoplay.coreui.Gray
import uz.javokhirdev.photoplay.coreui.LocalSpacing
import uz.javokhirdev.photoplay.coreui.components.ActionButton
import uz.javokhirdev.photoplay.coreui.components.BigImageLogo
import uz.javokhirdev.photoplay.coreui.components.OvalButton
import uz.javokhirdev.photoplay.coreui.components.TextButton

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val uiState = viewModel.uiState.collectAsState().value

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.image_movies),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(480.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(480.dp)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color.Transparent,
                            MaterialTheme.colors.background
                        )
                    )
                )
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp),
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(modifier = Modifier.height(90.dp))
                    BigImageLogo()
                    Spacer(modifier = Modifier.height(40.dp))
                    EmailInput(
                        email = uiState.email.orEmpty(),
                        onEmailChanged = {
                            viewModel.handleEvent(LoginEvent.EmailChanged(it))
                        }
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceNormal))
                    PasswordInput(
                        password = uiState.password.orEmpty(),
                        onPasswordChanged = {
                            viewModel.handleEvent(LoginEvent.PasswordChanged(it))
                        }
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceNormal))
                    TextButton(
                        text = stringResource(id = R.string.forgot),
                        modifier = Modifier.align(Alignment.End),
                        onClick = { viewModel.handleEvent(LoginEvent.OnForgotClick) }
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceMedium))
                    ActionButton(
                        text = stringResource(id = R.string.login),
                        onClick = { viewModel.handleEvent(LoginEvent.OnLoginClick) }
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceLarge))
                    Box(contentAlignment = Alignment.Center) {
                        Divider(color = Gray.copy(0.3f))
                        Text(
                            text = stringResource(id = R.string.social_logins),
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onBackground,
                            modifier = Modifier
                                .background(MaterialTheme.colors.background)
                                .padding(horizontal = 16.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(spacing.spaceNormal))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        OvalButton(iconRes = R.drawable.ic_facebook)
                        Spacer(modifier = Modifier.width(16.dp))
                        OvalButton(iconRes = R.drawable.ic_google)
                    }
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(
                        text = stringResource(id = R.string.have_an_account),
                        style = MaterialTheme.typography.body1,
                        color = Gray
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceExtraSmall))
                    TextButton(
                        text = stringResource(id = R.string.register),
                        onClick = { viewModel.handleEvent(LoginEvent.OnRegisterClick) }
                    )
                }
            }
        }
    }
}