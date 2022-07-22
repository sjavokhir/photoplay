package uz.javokhirdev.photoplay.home.presentation.dashboard

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.compose.currentBackStackEntryAsState
import uz.javokhirdev.photoplay.core.R
import uz.javokhirdev.photoplay.home.presentation.components.getIconTint

enum class DashboardSections(
    @StringRes val title: Int,
    val icon: ImageVector,
    val route: String
) {
    HOME(R.string.dashboard_home, Icons.Rounded.Home, "dashboard/home"),
    SEARCH(R.string.dashboard_search, Icons.Rounded.Search, "dashboard/search"),
    DOWNLOADS(R.string.dashboard_downloads, Icons.Rounded.Home, "dashboard/downloads"),
    PROFILE(R.string.dashboard_profile, Icons.Rounded.Person, "dashboard/profile")
}

@Composable
fun PhotoPlayBottomBar(
    navController: NavController,
    tabs: Array<DashboardSections>
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val dashboardSections = remember { DashboardSections.values() }
    val routes = remember { dashboardSections.map { it.route } }

    if (currentRoute in routes) {
        val currentSection = dashboardSections.first { it.route == currentRoute }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.surface.copy(alpha = 0.5f))
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                tabs.forEach { section ->
                    val selected = section == currentSection
                    val tint by getIconTint(selected = selected)

                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = section.icon,
                                tint = tint,
                                contentDescription = null
                            )
                        },
                        text = {
                            Text(
                                text = stringResource(section.title).uppercase(),
                                color = tint,
                                style = MaterialTheme.typography.h6,
                                maxLines = 1
                            )
                        },
                        selected = selected,
                        onSelected = {
                            if (section.route != currentRoute) {
                                navController.navigate(section.route) {
                                    launchSingleTop = true
                                    restoreState = true
                                    popUpTo(findStartDestination(navController.graph).id) {
                                        saveState = true
                                    }
                                }
                            }
                        },
                        modifier = BottomNavigationItemPadding.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun BottomNavigationItem(
    icon: @Composable BoxScope.() -> Unit,
    text: @Composable BoxScope.() -> Unit,
    selected: Boolean,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.selectable(selected = selected, onClick = onSelected)
    ) {
        Box(
            modifier = Modifier.layoutId("icon"),
            content = icon
        )
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier.layoutId("text"),
            content = text
        )
    }
}

private val BottomNavigationItemPadding = Modifier.padding(
    horizontal = 8.dp,
    vertical = 8.dp
)

private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

/**
 * Copied from similar function in NavigationUI.kt
 *
 * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:navigation/navigation-ui/src/main/java/androidx/navigation/ui/NavigationUI.kt
 */
private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}