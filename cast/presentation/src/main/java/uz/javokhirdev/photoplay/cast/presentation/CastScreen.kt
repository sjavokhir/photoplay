package uz.javokhirdev.photoplay.cast.presentation

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import uz.javokhirdev.photoplay.core.R
import uz.javokhirdev.photoplay.core.domain.model.Movie
import uz.javokhirdev.photoplay.coreui.LocalSpacing
import uz.javokhirdev.photoplay.coreui.components.BackButton
import uz.javokhirdev.photoplay.coreui.components.BottomGradientImage
import uz.javokhirdev.photoplay.coreui.components.PhotoPlaySurface
import uz.javokhirdev.photoplay.coreui.components.TextHeader

@ExperimentalCoilApi
@Composable
fun CastScreen(
    viewModel: CastViewModel = hiltViewModel(),
    navigateUp: () -> Unit
) {
    val spacing = LocalSpacing.current
    val uiState = viewModel.uiState.collectAsState().value
    val actor = uiState.actor

    PhotoPlaySurface(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                Box {
                    BottomGradientImage(
                        imageUrl = actor?.imageUrl.orEmpty(),
                        height = 400.dp
                    )
                    BackButton(onClick = navigateUp)
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .align(Alignment.BottomCenter)
                    ) {
                        Text(
                            text = actor?.name.orEmpty(),
                            style = MaterialTheme.typography.h1,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colors.onBackground,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Spacer(modifier = Modifier.height(spacing.spaceNormal))
                Text(
                    text = actor?.about.orEmpty(),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(spacing.spaceLarge))
                MoviesForm(watchings = uiState.movies.orEmpty())
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun MoviesForm(
    modifier: Modifier = Modifier,
    watchings: List<Movie> = emptyList()
) {
    val spacing = LocalSpacing.current

    Column(modifier = modifier.fillMaxWidth()) {
        TextHeader(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = stringResource(id = R.string.known_for)
        )
        Spacer(modifier = Modifier.height(spacing.spaceNormal))
        LazyRow {
            item { Spacer(modifier = Modifier.width(20.dp)) }
            items(watchings) {
                MovieItem(
                    name = it.name,
                    imageUrl = it.imageUrl
                )
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    name: String? = "",
    imageUrl: String? = ""
) {
    val spacing = LocalSpacing.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(96.dp)
            .clip(MaterialTheme.shapes.small)
    ) {
        Image(
            painter = rememberImagePainter(
                data = imageUrl,
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
            text = name.orEmpty(),
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onBackground,
            textAlign = TextAlign.Center
        )
    }
}