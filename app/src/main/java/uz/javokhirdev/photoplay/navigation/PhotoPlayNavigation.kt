package uz.javokhirdev.photoplay.navigation

import androidx.navigation.NavHostController

object Route {
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val FORGOT_PASSWORD = "forgot_password"

    const val DASHBOARD = "dashboard"
    const val MOVIE_DETAIL = "movie_detail"
    const val CAST = "cast"
}

object Params {
    const val MOVIE_ID_KEY = "movie_id"
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
    val navigateToMovieDetail = { movieId: Int? ->
        navController.navigate("${Route.MOVIE_DETAIL}/$movieId") {
            launchSingleTop = true
        }
    }
}