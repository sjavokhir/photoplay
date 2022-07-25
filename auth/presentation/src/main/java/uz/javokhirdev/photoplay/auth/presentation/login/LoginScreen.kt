package uz.javokhirdev.photoplay.auth.presentation.login

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import uz.javokhirdev.photoplay.auth.presentation.components.EmailInput
import uz.javokhirdev.photoplay.auth.presentation.components.PasswordInput
import uz.javokhirdev.photoplay.core.R
import uz.javokhirdev.photoplay.core.util.IMAGE_MOVIES
import uz.javokhirdev.photoplay.coreui.Gray
import uz.javokhirdev.photoplay.coreui.LocalSpacing
import uz.javokhirdev.photoplay.coreui.components.*

@ExperimentalCoilApi
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navigateToDashboard: () -> Unit = {},
    navigateToRegister: () -> Unit = {},
    navigateToForgotPassword: () -> Unit = {},
) {
    val spacing = LocalSpacing.current
    val uiState = viewModel.uiState.collectAsState().value

    if (uiState.isSuccess) {
        navigateToDashboard()
    } else {
        Box(modifier = Modifier.fillMaxSize()) {
            BottomGradientImage(imageUrl = IMAGE_MOVIES)
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 40.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Spacer(modifier = Modifier.height(90.dp))
                        PhotoPlayLogo()
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
                            onClick = navigateToForgotPassword
                        )
                        Spacer(modifier = Modifier.height(spacing.spaceMedium))
                        ActionButton(
                            modifier = Modifier.fillMaxWidth(),
                            title = stringResource(id = R.string.login),
                            onClick = { viewModel.handleEvent(LoginEvent.OnLoginClick) },
                            isLoading = uiState.isLoading
                        )
                        Spacer(modifier = Modifier.height(spacing.spaceLarge))
                        SocialLogins()
                        Spacer(modifier = Modifier.height(40.dp))
                        Text(
                            text = stringResource(id = R.string.have_an_account),
                            style = MaterialTheme.typography.body1,
                            color = Gray
                        )
                        Spacer(modifier = Modifier.height(spacing.spaceExtraSmall))
                        TextButton(
                            text = stringResource(id = R.string.register),
                            onClick = navigateToRegister
                        )
                        Spacer(modifier = Modifier.height(spacing.spaceMedium))
                    }
                }
            }
        }
    }
}

@Composable
private fun SocialLogins(
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
    }
}