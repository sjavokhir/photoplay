package uz.javokhirdev.photoplay.navigation

import androidx.navigation.NavHostController

object Route {
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val FORGOT_PASSWORD = "forgot_password"

    const val DASHBOARD = "dashboard"
    const val MOVIE_DETAILS = "movie_details"
    const val TV_SHOW_DETAILS = "tv_show_details"
    const val CAST = "cast"
}

class PhotoPlayNavigationActions(navController: NavHostController) {
    val navigateToRegister: () -> Unit = {
        navController.navigate(Route.REGISTER)
    }
    val navigateToForgotPassword: () -> Unit = {
        navController.navigate(Route.FORGOT_PASSWORD)
    }
    val navigateToDashboardFromLogin: () -> Unit = {
        navController.navigate(Route.DASHBOARD) {
            popUpTo(Route.LOGIN) {
                inclusive = true
            }
        }
    }
    val navigateToDashboardFromRegister: () -> Unit = {
        navController.navigate(Route.DASHBOARD) {
            popUpTo(Route.REGISTER) {
                inclusive = true
            }
        }
    }
}