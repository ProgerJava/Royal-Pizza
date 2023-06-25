package com.softroyalcompanyltd.royalpizza.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun setDrawMenu(expanded: MutableState<Boolean>, your_town: MutableState<String>) {
    DropdownMenu(
        modifier = Modifier.padding(start = 10.dp),
        expanded = expanded.value,
        onDismissRequest = { expanded.value = false }
    ) {
        Text(text = "Москва", modifier = Modifier
            .padding(3.dp)
            .clickable {
                your_town.value = "Москва"
            })
        Text(text = "Владимир", modifier = Modifier
            .padding(3.dp)
            .clickable {
                your_town.value = "Владимир"
            })
        Text(text = "Екатеринбург", modifier = Modifier
            .padding(3.dp)
            .clickable {
                your_town.value = "Екатеринбург"
            })
        Text(text = "Сочи", modifier = Modifier
            .padding(3.dp)
            .clickable {
                your_town.value = "Сочи"
            })
        Text(text = "Самара", modifier = Modifier
            .padding(3.dp)
            .clickable {
                your_town.value = "Самара"
            })
    }
}