package uz.javokhirdev.photoplay.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

object Route {
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val FORGOT_PASSWORD = "forgot_password"

    const val HOME = "home"
    const val MOVIE_DETAILS = "movie_details"
    const val TV_SHOW_DETAILS = "tv_show_details"
    const val CAST = "cast"
    const val SEARCH = "search"
    const val DOWNLOADS = "downloads"
    const val PROFILE = "profile"
}

class PhotoPlayNavigationActions(navController: NavHostController) {
    val navigateToRegister: () -> Unit = {
        navController.navigate(Route.REGISTER) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
    val navigateToForgotPassword: () -> Unit = {
        navController.navigate(Route.FORGOT_PASSWORD) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}