package com.client.aircasting.ui.view.main.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.client.aircasting.R
import com.client.aircasting.ui.view.navigation.NavRoutes

@Composable
fun TopBar(navController: NavController) {
    TopAppBar(
        elevation = 0.dp,
        title = {
            Text(
                modifier = Modifier.padding(start = 5.dp, top = 20.dp, bottom = 5.dp),
                text = stringResource(R.string.title_dashboard),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        },
        backgroundColor = Color.White,
        contentColor = colorResource(id = R.color.aircasting_dark_blue),
        actions = {
            IconButton(
                modifier = Modifier.padding(start = 5.dp, top = 20.dp, bottom = 5.dp),
                onClick = { goToSearchFollow(navController) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search_group),
                    contentDescription = stringResource(id = R.string.search_session_query_hint),
                    tint = colorResource(id = R.color.aircasting_blue_400)
                )
            }
        })
}

private fun goToSearchFollow(navController: NavController) {
    navController.navigate(NavRoutes.SearchFollowResult.route)
}

@Preview
@Composable
fun TopBarPreview() {
    val navController = rememberNavController()
    TopBar(navController = navController)
}