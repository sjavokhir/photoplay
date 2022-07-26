package uz.javokhirdev.photoplay.search.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import uz.javokhirdev.photoplay.core.R
import uz.javokhirdev.photoplay.core.domain.model.GroupMovie
import uz.javokhirdev.photoplay.coreui.Gray
import uz.javokhirdev.photoplay.coreui.LocalSpacing
import uz.javokhirdev.photoplay.search.presentation.components.SearchInput

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel()
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val spacing = LocalSpacing.current
    val uiState = viewModel.uiState.collectAsState().value

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        SearchInput(
            text = uiState.query,
            onValueChange = {
                viewModel.handleEvent(SearchEvent.OnQueryChange(it))
            },
            onSearch = {
                keyboardController?.hide()
                viewModel.handleEvent(SearchEvent.OnSearch)
            },
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(uiState.movies) {
                SearchItem(group = it)
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        when {
            uiState.isSearching -> CircularProgressIndicator()
            uiState.movies.isEmpty() -> {
                Text(
                    text = stringResource(id = R.string.no_results),
                    style = MaterialTheme.typography.h3,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun SearchItem(
    modifier: Modifier = Modifier,
    group: GroupMovie
) {
    val spacing = LocalSpacing.current

    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = group.title.uppercase(),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.width(spacing.spaceNormal))
            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = Gray
            )
        }
        Spacer(modifier = Modifier.height(spacing.spaceNormal))
        LazyRow {
            item { Spacer(modifier = Modifier.width(20.dp)) }
            items(group.movies) {
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
                        .clickable { }
                )
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}
