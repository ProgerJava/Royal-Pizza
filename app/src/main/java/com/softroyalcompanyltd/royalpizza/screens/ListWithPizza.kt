package com.softroyalcompanyltd.royalpizza.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softroyalcompanyltd.royalpizza.MAIN_INSTANCE
import com.softroyalcompanyltd.royalpizza.R


@Composable
fun showListWithPizza() {
    val list = listOf(1,2,3,4,5)
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 10.dp)
    ) {
        items(items = list, itemContent = { item ->
            when (item) {
                1 -> {
                    setPizzaImage(
                        image = R.drawable.pizza_1,
                        name = MAIN_INSTANCE.getString(R.string.pizza_name1),
                        compound = MAIN_INSTANCE.getString(R.string.pizza_compound1),
                        cost = MAIN_INSTANCE.getString(R.string.pizza_cost1))
                }
                2 -> {
                    setPizzaImage(
                        image = R.drawable.pizza_2,
                        name = MAIN_INSTANCE.getString(R.string.pizza_name2),
                        compound = MAIN_INSTANCE.getString(R.string.pizza_compound2),
                        cost = MAIN_INSTANCE.getString(R.string.pizza_cost2),
                    )
                }
                3 -> {
                    setPizzaImage(
                        image = R.drawable.pizza_3,
                        name = MAIN_INSTANCE.getString(R.string.pizza_name3),
                        compound = MAIN_INSTANCE.getString(R.string.pizza_compound3),
                        cost = MAIN_INSTANCE.getString(R.string.pizza_cost3),
                    )
                }
                4 -> {
                    setPizzaImage(
                        image = R.drawable.pizza_4,
                        name = MAIN_INSTANCE.getString(R.string.pizza_name4),
                        compound = MAIN_INSTANCE.getString(R.string.pizza_compound4),
                        cost = MAIN_INSTANCE.getString(R.string.pizza_cost4),
                    )
                }
                5 -> {
                    setPizzaImage(
                        image = R.drawable.pizza_5,
                        name = MAIN_INSTANCE.getString(R.string.pizza_name5),
                        compound = MAIN_INSTANCE.getString(R.string.pizza_compound5),
                        cost = MAIN_INSTANCE.getString(R.string.pizza_cost5),
                    )
                }
                
            }
        })
    }
}
@Composable
private fun setPizzaImage (image : Int, name : String, compound : String, cost : String) {
    val colorFocus = remember { (Color(0xFFFD3A69)) }


    Spacer(modifier = Modifier
        .padding(end = 8.dp, top = 8.dp)
        .fillMaxWidth()
        .height(2.dp)
        .background(Color.LightGray))
    Row(
        Modifier
            .background(Color.Transparent)
            .padding(top = 15.dp)
            .clickable {
                Toast
                    .makeText(MAIN_INSTANCE, "Я пока не работаю", Toast.LENGTH_SHORT)
                    .show()
            }) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "",
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .padding(8.dp, end = 10.dp)
        )
        Column() {
            Text(text = name, fontWeight = FontWeight.Bold)
            Text(text = compound,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .height(90.dp),
                color = Color.LightGray
            )
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp)
            ) {
                Button(
                    modifier = Modifier
                        .height(45.dp)
                        .width(110.dp),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = colorFocus
                    ),
                    border = BorderStroke(2.dp, colorFocus),
                    shape = RoundedCornerShape(size = 9.dp),
                )
                {
                    Text(cost, fontSize = 15.sp, textAlign = TextAlign.Center)
                }
            }
        }
    }
}