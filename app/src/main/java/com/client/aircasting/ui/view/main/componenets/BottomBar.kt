package com.client.aircasting.ui.view.main.componenets

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import com.client.aircasting.R

@Composable
fun BottomBar() {
    val selectedIndex = remember { mutableStateOf(0) }
    NavigationBar() {
        BottomNavigationItem(icon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_home_black_24dp),
                ""
            )
        }, selectedContentColor = colorResource(id = R.color.aircasting_blue_400),
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = ImageVector.vectorResource(id = R.drawable.ic_plus_black_24), "")
        },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
            })

        BottomNavigationItem(icon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_settings_black_24dp),
                ""
            )
        },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
            })
    }
}