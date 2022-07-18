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
import uz.javokhirdev.photoplay.coreui.components.BigImageLogo

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val uiState = viewModel.uiState.collectAsState().value

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            BackButton()
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        vertical = 20.dp,
                        horizontal = 40.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                BigImageLogo()
                Spacer(modifier = Modifier.height(spacing.spaceLarge))
                TextInput(
                    text = uiState.email.orEmpty(),
                    onTextChanged = {
                        viewModel.handleEvent(RegisterEvent.FirstNameChanged(it))
                    }
                )
                TextInput(
                    text = uiState.email.orEmpty(),
                    onTextChanged = {
                        viewModel.handleEvent(RegisterEvent.LastNameChanged(it))
                    }
                )
                EmailInput(
                    email = uiState.email.orEmpty(),
                    onEmailChanged = {
                        viewModel.handleEvent(RegisterEvent.EmailChanged(it))
                    }
                )
                PasswordInput(
                    password = uiState.password.orEmpty(),
                    onPasswordChanged = {
                        viewModel.handleEvent(RegisterEvent.PasswordChanged(it))
                    }
                )
                PasswordInput(
                    password = uiState.confirmPassword.orEmpty(),
                    onPasswordChanged = {
                        viewModel.handleEvent(RegisterEvent.ConfirmPasswordChanged(it))
                    }
                )
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                ActionButton(
                    text = stringResource(id = R.string.register),
                    onClick = { viewModel.handleEvent(RegisterEvent.OnRegisterClick) }
                )
            }
        }
    }
}