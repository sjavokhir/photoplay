package uz.javokhirdev.photoplay.coreui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uz.javokhirdev.photoplay.coreui.LocalSpacing

@Composable
fun GenresForm(
    modifier: Modifier = Modifier,
    genres: List<String>
) {
    val spacing = LocalSpacing.current

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        itemsIndexed(genres) { index, text ->
            Text(
                text = text,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onBackground
            )
            if (index != genres.size - 1) {
                Spacer(modifier = Modifier.width(spacing.spaceNormal))
                Divider(
                    modifier = Modifier
                        .width(1.dp)
                        .height(12.dp)
                        .background(color = MaterialTheme.colors.onBackground)
                )
                Spacer(modifier = Modifier.width(spacing.spaceNormal))
            }
        }
    }
}