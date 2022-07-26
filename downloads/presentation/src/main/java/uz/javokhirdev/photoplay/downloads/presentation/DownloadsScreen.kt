package uz.javokhirdev.photoplay.downloads.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import uz.javokhirdev.photoplay.core.domain.model.Download
import uz.javokhirdev.photoplay.coreui.Gray
import uz.javokhirdev.photoplay.coreui.LocalSpacing
import uz.javokhirdev.photoplay.coreui.components.PhotoPlaySurface

@ExperimentalCoilApi
@Composable
fun DownloadsScreen(
    viewModel: DownloadsViewModel = hiltViewModel(),
    navigateToMovieDetail: (Int?) -> Unit
) {
    val spacing = LocalSpacing.current
    val uiState = viewModel.uiState.collectAsState().value

    PhotoPlaySurface(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            item {
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
            }
            items(uiState.downloads.orEmpty()) {
                DownloadItem(
                    download = it,
                    onMovieClick = navigateToMovieDetail
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun DownloadItem(
    modifier: Modifier = Modifier,
    download: Download,
    onMovieClick: (Int?) -> Unit
) {
    val spacing = LocalSpacing.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clickable { onMovieClick(download.id) }
    ) {
        Image(
            painter = rememberImagePainter(
                data = download.imageUrl,
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(140.dp)
                .height(90.dp)
                .clip(MaterialTheme.shapes.small)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Column {
            Text(
                text = download.name.orEmpty(),
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(spacing.spaceExtraSmall))
            Text(
                text = download.size.orEmpty(),
                style = MaterialTheme.typography.body1,
                color = Gray
            )
        }
    }
}