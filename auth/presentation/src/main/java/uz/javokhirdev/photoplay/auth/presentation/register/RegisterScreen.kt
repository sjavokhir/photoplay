package uz.javokhirdev.photoplay.auth.presentation.register

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import uz.javokhirdev.photoplay.auth.presentation.components.EmailInput
import uz.javokhirdev.photoplay.auth.presentation.components.PasswordInput
import uz.javokhirdev.photoplay.auth.presentation.components.TextInput
import uz.javokhirdev.photoplay.core.R
import uz.javokhirdev.photoplay.coreui.LocalSpacing
import uz.javokhirdev.photoplay.coreui.components.ActionButton
import uz.javokhirdev.photoplay.coreui.components.BackButton
import uz.javokhirdev.photoplay.coreui.components.PhotoPlayLogo

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = hiltViewModel(),
    navigateUp: () -> Unit = {},
    navigateToDashboard: () -> Unit = {}
) {
    val spacing = LocalSpacing.current
    val uiState = viewModel.uiState.collectAsState().value

    if (uiState.isSuccess) {
        navigateToDashboard()
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                BackButton(onClick = navigateUp)
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(modifier = Modifier.height(34.dp))
                    PhotoPlayLogo()
                    Spacer(modifier = Modifier.height(spacing.spaceLarge))
                    TextInput(
                        text = uiState.firstName.orEmpty(),
                        title = stringResource(id = R.string.first_name),
                        hint = stringResource(id = R.string.first_name_hint),
                        onTextChanged = {
                            viewModel.handleEvent(RegisterEvent.FirstNameChanged(it))
                        }
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceNormal))
                    TextInput(
                        text = uiState.lastName.orEmpty(),
                        title = stringResource(id = R.string.last_name),
                        hint = stringResource(id = R.string.last_name_hint),
                        onTextChanged = {
                            viewModel.handleEvent(RegisterEvent.LastNameChanged(it))
                        }
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceNormal))
                    EmailInput(
                        email = uiState.email.orEmpty(),
                        onEmailChanged = {
                            viewModel.handleEvent(RegisterEvent.EmailChanged(it))
                        }
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceNormal))
                    PasswordInput(
                        password = uiState.password.orEmpty(),
                        onPasswordChanged = {
                            viewModel.handleEvent(RegisterEvent.PasswordChanged(it))
                        }
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceNormal))
                    PasswordInput(
                        password = uiState.confirmPassword.orEmpty(),
                        title = stringResource(id = R.string.confirm_password),
                        hint = stringResource(id = R.string.confirm_password_hint),
                        onPasswordChanged = {
                            viewModel.handleEvent(RegisterEvent.ConfirmPasswordChanged(it))
                        }
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceMedium))
                    ActionButton(
                        title = stringResource(id = R.string.register),
                        onClick = { viewModel.handleEvent(RegisterEvent.OnRegisterClick) },
                        isLoading = uiState.isLoading
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceMedium))
                }
            }
        }
    }
}