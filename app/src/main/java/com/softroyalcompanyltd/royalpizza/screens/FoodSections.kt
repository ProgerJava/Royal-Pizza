package com.softroyalcompanyltd.royalpizza.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softroyalcompanyltd.royalpizza.MAIN_INSTANCE
import com.softroyalcompanyltd.royalpizza.R


@Composable
fun showFoodSections () {

    val list = listOf (
        R.string.sectionsName1,
        R.string.sectionsName2,
        R.string.sectionsName3,
        R.string.sectionsName4,)

    var focusButton = remember { mutableStateOf("") }

    LazyRow(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 4.dp, top = 15.dp)) {
        items(items = list, itemContent = { item ->
            when (item) {
                R.string.sectionsName1 ->  {setFoodSection(sectionName = MAIN_INSTANCE.getString(R.string.sectionsName1), focusButton)}
                R.string.sectionsName2 ->  {setFoodSection(sectionName = MAIN_INSTANCE.getString(R.string.sectionsName2),
                    focusButton = focusButton
                )}
                R.string.sectionsName3 ->  {setFoodSection(
                    sectionName = MAIN_INSTANCE.getString(R.string.sectionsName3),
                    focusButton = focusButton
                )}
                R.string.sectionsName4 ->  {setFoodSection(
                    sectionName = MAIN_INSTANCE.getString(R.string.sectionsName4),
                    focusButton = focusButton
                )}
            }
        })

    }

}
@Composable
private fun setFoodSection(sectionName: String, focusButton: MutableState<String>) {

    val colorBack = remember { (Color(0xFFffc0cb)) }
    val colorFocus = remember { (Color(0xFFFD3A69)) }


    Button(
        modifier = Modifier
            .height(45.dp)
            .width(140.dp)
            .padding(start = 5.dp),
        onClick = {
            focusButton.value = sectionName
        },
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 20.dp
        ),
        shape = RoundedCornerShape(size = 9.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (sectionName == focusButton.value) {
                colorBack
            } else {
                Color.White
            }, contentColor = if (sectionName == focusButton.value){
                colorFocus
            } else {
                Color.LightGray
            }
        )
    )
    {
        Text(sectionName, fontSize = 15.sp, textAlign = TextAlign.Center)
    }
}