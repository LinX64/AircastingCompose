package com.client.aircasting.util.session_card

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutScope

@Composable
fun ExpandedView(
    constraintLayout: ConstraintLayoutScope,
    expandedState: Boolean,
    txtDescription: ConstrainedLayoutReference,
    txtLastMin: ConstrainedLayoutReference
) {
    if (expandedState) {
        constraintLayout.apply {

            Text(
                modifier = Modifier
                    .constrainAs(txtDescription) {
                        top.linkTo(txtLastMin.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .padding(top = 30.dp),
                overflow = TextOverflow.Ellipsis,
                text = "sdssdfsdssdfdsfsdssdfdsfsdssdfdsfsdssdfdsfsdssdfdsfsdssdfdsfdsf")
        }
    }
}