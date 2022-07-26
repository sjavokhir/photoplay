package uz.javokhirdev.photoplay.home.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import uz.javokhirdev.photoplay.core.R
import uz.javokhirdev.photoplay.core.domain.model.Movie
import uz.javokhirdev.photoplay.coreui.LocalSpacing
import uz.javokhirdev.photoplay.coreui.components.*

@ExperimentalCoilApi
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToMovieDetail: (Int?) -> Unit
) {
    val spacing = LocalSpacing.current
    val uiState = viewModel.uiState.collectAsState().value
    val movie = uiState.randomMovie

    PhotoPlaySurface(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                BottomGradientImage(imageUrl = movie?.imageUrl.orEmpty())
                Text(
                    text = ((movie?.rating ?: 0f) * 2).toString(),
                    style = MaterialTheme.typography.h1,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(spacing.spaceSmall))
                RatingBar(
                    rating = movie?.rating,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(spacing.spaceNormal))
                GenresForm(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    genres = movie?.genres.orEmpty()
                )
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                WatchingsForm(
                    watchings = uiState.watchings.orEmpty(),
                    onMovieClick = navigateToMovieDetail
                )
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun WatchingsForm(
    modifier: Modifier = Modifier,
    watchings: List<Movie> = emptyList(),
    onMovieClick: (Int?) -> Unit
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
                        .clickable { onMovieClick(it.id) }
                )
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}