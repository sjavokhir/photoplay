package uz.javokhirdev.photoplay.auth.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import uz.javokhirdev.photoplay.auth.domain.model.PasswordRequirement
import uz.javokhirdev.photoplay.core.R
import uz.javokhirdev.photoplay.coreui.Gray
import uz.javokhirdev.photoplay.coreui.LocalSpacing

@Composable
fun PasswordRequirements(
    modifier: Modifier = Modifier,
    completedPasswordRequirements: List<PasswordRequirement>
) {
    Column(
        modifier = modifier
    ) {
        PasswordRequirement.values().forEach { requirement ->
            Requirement(
                message = stringResource(
                    id = requirement.label
                ),
                satisfied = completedPasswordRequirements.contains(
                    requirement
                )
            )
        }
    }
}

@Composable
fun Requirement(
    modifier: Modifier = Modifier,
    message: String,
    satisfied: Boolean
) {
    val spacing = LocalSpacing.current
    val tint = if (satisfied) MaterialTheme.colors.primary else Gray
    val requirementStatus = if (satisfied) {
        stringResource(id = R.string.password_requirement_satisfied, message)
    } else {
        stringResource(id = R.string.password_requirement_needed, message)
    }

    Row(
        modifier = modifier
            .padding(6.dp)
            .semantics(mergeDescendants = true) {
                text = AnnotatedString(requirementStatus)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(12.dp),
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = tint
        )
        Spacer(modifier = Modifier.width(spacing.spaceSmall))
        Text(
            modifier = Modifier.clearAndSetSemantics { },
            text = message,
            style = MaterialTheme.typography.caption,
            color = tint
        )
    }
}