package uz.javokhirdev.photoplay.home.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle
import uz.javokhirdev.photoplay.core.R
import uz.javokhirdev.photoplay.core.domain.model.Movie
import uz.javokhirdev.photoplay.coreui.LocalSpacing
import uz.javokhirdev.photoplay.coreui.components.BottomGradientImage
import uz.javokhirdev.photoplay.coreui.components.GenresForm
import uz.javokhirdev.photoplay.coreui.components.PhotoPlaySurface
import uz.javokhirdev.photoplay.coreui.components.TextHeader

@ExperimentalCoilApi
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val uiState = viewModel.uiState.collectAsState().value
    val movie = uiState.randomMovie

    PhotoPlaySurface(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    BottomGradientImage(imageUrl = movie?.imageUrl.orEmpty())
                    Text(
                        text = ((movie?.rating ?: 0f) * 2).toString(),
                        style = MaterialTheme.typography.h2,
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceSmall))
                    RatingBar(
                        value = movie?.rating ?: 0f,
                        config = RatingBarConfig()
                            .style(RatingBarStyle.HighLighted),
                        onValueChange = {},
                        onRatingChanged = {},
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceNormal))
                    GenresForm(
                        modifier = Modifier.padding(horizontal = 20.dp),
                        genres = movie?.genres.orEmpty()
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceMedium))
                }
            }
            item {
                WatchingsForm(watchings = uiState.watchings.orEmpty())
            }
            item {
                Spacer(modifier = Modifier.height(90.dp))
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun WatchingsForm(
    modifier: Modifier = Modifier,
    watchings: List<Movie> = emptyList()
) {
    val spacing = LocalSpacing.current

    Column(modifier = modifier.fillMaxWidth()) {
        TextHeader(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = stringResource(id = R.string.watching)
        )
        Spacer(modifier = Modifier.height(spacing.spaceNormal))
        LazyRow {
            item { Spacer(modifier = Modifier.width(20.dp)) }
            items(watchings) {
                Image(
                    painter = rememberImagePainter(
                        data = it.imageUrl,
                        builder = {
                            crossfade(true)
                        }
                    ),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(96.dp)
                        .height(127.dp)
                        .clip(MaterialTheme.shapes.small)
                )
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}