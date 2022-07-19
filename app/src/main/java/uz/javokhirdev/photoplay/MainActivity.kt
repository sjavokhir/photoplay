package uz.javokhirdev.photoplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import dagger.hilt.android.AndroidEntryPoint
import uz.javokhirdev.photoplay.auth.presentation.forgot.ForgotPasswordScreen
import uz.javokhirdev.photoplay.auth.presentation.login.LoginScreen
import uz.javokhirdev.photoplay.auth.presentation.register.RegisterScreen
import uz.javokhirdev.photoplay.core.domain.preferences.Preferences
import uz.javokhirdev.photoplay.navigation.PhotoPlayNavigationActions
import uz.javokhirdev.photoplay.navigation.Route
import uz.javokhirdev.photoplay.ui.theme.CaloryTrackerTheme
import javax.inject.Inject

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val shouldShowLogin = preferences.loadShouldShowLogin()

        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                val navigationActions = remember(navController) {
                    PhotoPlayNavigationActions(navController)
                }
                val scaffoldState = rememberScaffoldState()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = if (shouldShowLogin) {
                            Route.LOGIN
                        } else {
                            Route.HOME
                        }
                    ) {
                        composable(Route.LOGIN) {
                            LoginScreen(
                                navigateToRegister = navigationActions.navigateToRegister,
                                navigateToForgotPassword = navigationActions.navigateToForgotPassword
                            )
                        }
                        composable(Route.REGISTER) {
                            RegisterScreen(
                                navigateUp = { navController.navigateUp() }
                            )
                        }
                        composable(Route.FORGOT_PASSWORD) {
                            ForgotPasswordScreen(
                                navigateUp = { navController.navigateUp() }
                            )
                        }
                        composable(Route.HOME) {

                        }
                    }
                }
            }
        }
    }
}