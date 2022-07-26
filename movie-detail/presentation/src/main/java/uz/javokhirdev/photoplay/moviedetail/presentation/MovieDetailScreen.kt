package uz.javokhirdev.photoplay.moviedetail.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayCircleFilled
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import uz.javokhirdev.photoplay.core.R
import uz.javokhirdev.photoplay.core.domain.model.Actor
import uz.javokhirdev.photoplay.coreui.LocalSpacing
import uz.javokhirdev.photoplay.coreui.components.*

@ExperimentalCoilApi
@Composable
fun MovieDetailScreen(
    viewModel: MovieDetailViewModel = hiltViewModel(),
    navigateUp: () -> Unit,
    navigateToCast: (Int?) -> Unit
) {
    val spacing = LocalSpacing.current
    val uiState = viewModel.uiState.collectAsState().value
    val movie = uiState.movie

    PhotoPlaySurface(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                Box {
                    BottomGradientImage(
                        imageUrl = movie?.imageUrl.orEmpty(),
                        height = 300.dp
                    )
                    BackButton(onClick = navigateUp)
                    OvalButton(
                        modifier = Modifier.align(Alignment.Center),
                        vector = Icons.Rounded.PlayCircleFilled,
                        size = 80.dp
                    )
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .align(Alignment.BottomStart)
                    ) {
                        Text(
                            text = movie?.name.orEmpty(),
                            style = MaterialTheme.typography.h2,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colors.onBackground,
                        )
                        Spacer(modifier = Modifier.height(spacing.spaceSmall))
                        GenresForm(genres = movie?.genres.orEmpty())
                    }
                }
                Spacer(modifier = Modifier.height(spacing.spaceNormal))
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
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                Text(
                    text = movie?.description.orEmpty(),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                ActionButton(
                    modifier = Modifier.width(160.dp),
                    title = stringResource(id = R.string.watch_now),
                    onClick = { },
                )
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                ActorsForm(
                    watchings = uiState.actors.orEmpty(),
                    navigateToCast = navigateToCast
                )
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun ActorsForm(
    modifier: Modifier = Modifier,
    watchings: List<Actor> = emptyList(),
    navigateToCast: (Int?) -> Unit
) {
    val spacing = LocalSpacing.current

    Column(modifier = modifier.fillMaxWidth()) {
        TextHeader(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = stringResource(id = R.string.cast)
        )
        Spacer(modifier = Modifier.height(spacing.spaceNormal))
        LazyRow {
            item { Spacer(modifier = Modifier.width(20.dp)) }
            items(watchings) {
                ActorItem(
                    actor = it,
                    navigateToCast = navigateToCast
                )
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun ActorItem(
    modifier: Modifier = Modifier,
    actor: Actor,
    navigateToCast: (Int?) -> Unit
) {
    val spacing = LocalSpacing.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(96.dp)
            .clip(MaterialTheme.shapes.small)
            .clickable { navigateToCast(actor.id) }
    ) {
        Image(
            painter = rememberImagePainter(
                data = actor.imageUrl,
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .width(96.dp)
                .height(127.dp)
                .clip(MaterialTheme.shapes.small)
        )
        Spacer(modifier = Modifier.height(spacing.spaceSmall))
        Text(
            text = actor.name.orEmpty(),
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onBackground,
            textAlign = TextAlign.Center
        )
    }
}