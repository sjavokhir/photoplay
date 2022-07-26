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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import dagger.hilt.android.AndroidEntryPoint
import uz.javokhirdev.photoplay.auth.presentation.forgot.ForgotPasswordScreen
import uz.javokhirdev.photoplay.auth.presentation.login.LoginScreen
import uz.javokhirdev.photoplay.auth.presentation.register.RegisterScreen
import uz.javokhirdev.photoplay.cast.presentation.CastScreen
import uz.javokhirdev.photoplay.core.domain.preferences.Preferences
import uz.javokhirdev.photoplay.core.util.Extras.CAST_ID_KEY
import uz.javokhirdev.photoplay.core.util.Extras.MOVIE_ID_KEY
import uz.javokhirdev.photoplay.downloads.presentation.DownloadsScreen
import uz.javokhirdev.photoplay.home.presentation.dashboard.DashboardSections
import uz.javokhirdev.photoplay.home.presentation.dashboard.PhotoPlayBottomBar
import uz.javokhirdev.photoplay.home.presentation.home.HomeScreen
import uz.javokhirdev.photoplay.moviedetail.presentation.MovieDetailScreen
import uz.javokhirdev.photoplay.navigation.PhotoPlayNavigationActions
import uz.javokhirdev.photoplay.navigation.Route
import uz.javokhirdev.photoplay.profile.presentation.ProfileScreen
import uz.javokhirdev.photoplay.ui.theme.CaloryTrackerTheme
import javax.inject.Inject

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@AndroidEntryPoint
class AppActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val shouldShowLogin = preferences.loadShouldShowLogin()

        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                val tabs = remember { DashboardSections.values() }
                val navActions = remember(navController) {
                    PhotoPlayNavigationActions(navController)
                }
                val scaffoldState = rememberScaffoldState()

                Scaffold(
                    bottomBar = {
                        PhotoPlayBottomBar(navController = navController, tabs = tabs)
                    },
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = if (shouldShowLogin) {
                            Route.LOGIN
                        } else {
                            Route.DASHBOARD
                        }
                    ) {
                        composable(Route.LOGIN) {
                            LoginScreen(
                                navigateToDashboard = navActions.navigateToDashboardFromLogin,
                                navigateToRegister = navActions.navigateToRegister,
                                navigateToForgotPassword = navActions.navigateToForgotPassword
                            )
                        }
                        composable(Route.REGISTER) {
                            RegisterScreen(
                                navigateToDashboard = navActions.navigateToDashboardFromRegister,
                                navigateUp = { navController.navigateUp() }
                            )
                        }
                        composable(Route.FORGOT_PASSWORD) {
                            ForgotPasswordScreen(
                                navigateUp = { navController.navigateUp() }
                            )
                        }
                        navigation(
                            route = Route.DASHBOARD,
                            startDestination = DashboardSections.HOME.route
                        ) {
                            composable(DashboardSections.HOME.route) {
                                HomeScreen(
                                    navigateToMovieDetail = navActions.navigateToMovieDetail
                                )
                            }
                            composable(DashboardSections.SEARCH.route) {
                            }
                            composable(DashboardSections.DOWNLOADS.route) {
                                DownloadsScreen(
                                    navigateToMovieDetail = navActions.navigateToMovieDetail
                                )
                            }
                            composable(DashboardSections.PROFILE.route) {
                                ProfileScreen()
                            }
                        }
                        composable(
                            route = "${Route.MOVIE_DETAIL}/{$MOVIE_ID_KEY}",
                            arguments = listOf(navArgument(MOVIE_ID_KEY) { type = NavType.IntType })
                        ) { from ->
                            val arguments = requireNotNull(from.arguments)
                            val movieId = arguments.getInt(MOVIE_ID_KEY)

                            MovieDetailScreen(
                                navigateUp = { navController.navigateUp() },
                                navigateToCast = navActions.navigateToCast
                            )
                        }
                        composable(
                            route = "${Route.CAST}/{$CAST_ID_KEY}",
                            arguments = listOf(navArgument(CAST_ID_KEY) { type = NavType.IntType })
                        ) { from ->
                            val arguments = requireNotNull(from.arguments)
                            val castId = arguments.getInt(CAST_ID_KEY)

                            CastScreen { navController.navigateUp() }
                        }
                    }
                }
            }
        }
    }
}