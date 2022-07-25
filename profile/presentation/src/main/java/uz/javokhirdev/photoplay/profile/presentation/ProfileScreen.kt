package uz.javokhirdev.photoplay.profile.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import uz.javokhirdev.photoplay.core.util.IMAGE_PROFILE
import uz.javokhirdev.photoplay.coreui.Gray
import uz.javokhirdev.photoplay.coreui.LocalSpacing
import uz.javokhirdev.photoplay.coreui.components.OvalImage
import uz.javokhirdev.photoplay.coreui.components.PhotoPlaySurface

@ExperimentalCoilApi
@Composable
fun ProfileScreen() {
    val spacing = LocalSpacing.current

    PhotoPlaySurface(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(spacing.spaceLarge))
                ProfileDetailForm()
                Spacer(modifier = Modifier.height(spacing.spaceLarge))
            }
            items(profileMenus) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 16.dp,
                            horizontal = 12.dp
                        )
                ) {
                    Icon(
                        imageVector = it.second,
                        contentDescription = it.first,
                        tint = MaterialTheme.colors.primary
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = it.first,
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onBackground
                    )
                }
                Divider(color = Gray)
            }
            item {
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun ProfileDetailForm(
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        OvalImage(imageUrl = IMAGE_PROFILE)
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        Text(
            text = "Javokhir Savriev",
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onBackground
        )
        Text(
            text = "Premium",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primary
        )
    }
}

private val profileMenus = arrayListOf(
    "Account" to Icons.Rounded.Person,
    "Notifications" to Icons.Rounded.Notifications,
    "Settings" to Icons.Rounded.Settings,
    "Help" to Icons.Rounded.Help,
    "Logout" to Icons.Rounded.Logout
)
