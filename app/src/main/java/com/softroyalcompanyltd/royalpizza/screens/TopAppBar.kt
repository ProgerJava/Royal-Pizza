package com.softroyalcompanyltd.royalpizza.screens

import android.annotation.SuppressLint
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softroyalcompanyltd.royalpizza.MAIN_INSTANCE
import com.softroyalcompanyltd.royalpizza.R
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState


@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("RememberReturnType")
@Composable
fun drawTopAppBar() {

    var expanded = remember { mutableStateOf(false) }
    var your_town = remember { mutableStateOf("Москва") }
    val list = listOf (
        R.drawable.banner_1,
        R.drawable.banner_2,
        R.drawable.banner_3,
        R.drawable.banner_4)

    CollapsingToolbarScaffold(
        modifier = Modifier
            .fillMaxWidth(),
        state = rememberCollapsingToolbarScaffoldState(),
        scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
        toolbar = {
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .height(60.dp)
                    .pin()
            )
            Column() {
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        Modifier
                            .padding(start = 8.dp, top = 8.dp)
                            .clickable {
                                expanded.value = !expanded.value
                            }) {
                        Text(
                            modifier = Modifier
                                .wrapContentWidth()
                                .padding(end = 4.dp),
                            text = your_town.value,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "More",
                            modifier = Modifier.size(30.dp)
                        )
                        setDrawMenu(expanded, your_town)
                    }
                    Image(
                        modifier = Modifier
                            .clickable {
                                Toast
                                    .makeText(
                                        MAIN_INSTANCE,
                                        "Пока ничего не умею делать",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            }
                            .padding(16.dp)
                            .size(30.dp),
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = ""
                    )
                }
                LazyRow(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp)) {
                    items(items = list, itemContent = { item ->
                        when (item) {
                            R.drawable.banner_1 ->  {setBanner(banner = R.drawable.banner_4)}
                            R.drawable.banner_2 ->  {setBanner(banner = R.drawable.banner_3)}
                            R.drawable.banner_3 ->  {setBanner(banner = R.drawable.banner_2)}
                            R.drawable.banner_4 ->  {setBanner(banner = R.drawable.banner_1)}
                        }
                    })

                }
            }
        }
    ) {
        Column {
            showFoodSections()
            showListWithPizza()
        }
    }
}
@Composable
private fun setBanner(banner: Int) {
    Card(
        Modifier
            .width(300.dp)
            .height(150.dp)
            .padding(8.dp)
            .background(Color.White),
        ) {
        Image(
            painter = painterResource(id = banner),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}