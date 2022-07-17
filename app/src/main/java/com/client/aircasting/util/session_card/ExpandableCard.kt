package com.client.aircasting.util.session_card

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.client.aircasting.R

@ExperimentalMaterialApi
@Composable
fun ExpandableCard(
    date: String,
    title: String,
    type: String,
    lastMinute: String
) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(if (expandedState) 180f else 0f)

    Card(
        modifier = Modifier
            .padding(10.dp).fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        onClick = { expandedState = !expandedState }) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (txtDate, txtTitle, dropDownIcon, txtSensor, txtLastMin, txtDescription) = createRefs()

            Text(
                modifier = Modifier.constrainAs(txtDate) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
                text = date, maxLines = 1,
                color = colorResource(R.color.aircasting_grey_300),
            )

            Text(
                modifier = Modifier
                    .constrainAs(txtTitle) {
                        top.linkTo(txtDate.bottom)
                        start.linkTo(parent.start)
                    }
                    .padding(top = 10.dp),
                text = title,
                fontSize = MaterialTheme.typography.h6.fontSize,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.aircasting_dark_blue),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            IconButton(
                modifier = Modifier
                    .constrainAs(dropDownIcon) {
                        top.linkTo(txtDate.bottom)
                        end.linkTo(parent.end)
                    }
                    .rotate(rotationState),
                onClick = {
                    expandedState = !expandedState
                }) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    ""
                )
            }

            Text(
                modifier = Modifier
                    .constrainAs(txtSensor) {
                        top.linkTo(txtTitle.bottom)
                        start.linkTo(parent.start)
                    }
                    .padding(top = 5.dp),
                text = type, maxLines = 1
            )

            Text(
                modifier = Modifier
                    .constrainAs(txtLastMin) {
                        top.linkTo(txtSensor.bottom)
                        start.linkTo(parent.start)
                    }
                    .padding(top = 15.dp),
                text = lastMinute,
                maxLines = 1
            )

            ExpandedView(this, expandedState, txtDescription, txtLastMin)
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview(showBackground = true)
fun ExpandableCardPreview() {
    ExpandableCard(
        date = "02/12/2012 - 12:00 pm - 1:00 am",
        title = "Office AB3",
        type = "Fixed : Airbeam 3",
        lastMinute = "Last minute measurements"
    )
}