package com.softroyalcompanyltd.royalpizza.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.softroyalcompanyltd.royalpizza.R


@Composable
fun showBottomNavigationBar () {

    val colorFocus = remember { (Color(0xFFFD3A69)) }

    var colorIcon1 = remember { mutableStateOf(Color.Black) }
    var colorIcon2 = remember { mutableStateOf(Color.Black) }
    var colorIcon3 = remember { mutableStateOf(Color.Black) }



    BottomAppBar(Modifier.fillMaxWidth()) {
        Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable {
                    colorIcon1.value = colorFocus
                    colorIcon2.value = Color.Black
                    colorIcon3.value = Color.Black

                }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_nav1),
                    modifier = Modifier
                        .weight(1f),
                    tint = colorIcon1.value,
                    contentDescription = ""
                )
                Text(text = "Меню", Modifier.padding(bottom = 10.dp), color = Color(colorIcon1.value.value))
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable {
                colorIcon1.value = Color.Black
                colorIcon2.value = colorFocus
                colorIcon3.value = Color.Black
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_nav2),
                    modifier = Modifier.weight(1f),
                    contentDescription = "",
                    tint = colorIcon2.value
                )
                Text(text = "Профиль", Modifier.padding(bottom = 10.dp), color = Color(colorIcon2.value.value))
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable {
                colorIcon1.value = Color.Black
                colorIcon2.value = Color.Black
                colorIcon3.value = colorFocus
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_nav3),
                    modifier = Modifier.weight(1f),
                    contentDescription = "",
                    tint = colorIcon3.value
                )
                Text(text = "Корзина", Modifier.padding(bottom = 10.dp), color = Color(colorIcon3.value.value))
            }
        }
    }
}