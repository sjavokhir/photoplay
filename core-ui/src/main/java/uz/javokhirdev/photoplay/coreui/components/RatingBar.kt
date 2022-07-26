package uz.javokhirdev.photoplay.coreui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Float? = 0f
) {
    com.gowtham.ratingbar.RatingBar(
        value = rating ?: 0f,
        config = RatingBarConfig()
            .style(RatingBarStyle.HighLighted),
        onValueChange = {},
        onRatingChanged = {},
        modifier = modifier
    )
}