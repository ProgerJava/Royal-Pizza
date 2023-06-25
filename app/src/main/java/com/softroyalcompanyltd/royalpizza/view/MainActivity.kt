package com.softroyalcompanyltd.royalpizza.view

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.softroyalcompanyltd.royalpizza.objectInstanceMain
import com.softroyalcompanyltd.royalpizza.screens.drawTopAppBar
import com.softroyalcompanyltd.royalpizza.screens.showBottomNavigationBar

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        objectInstanceMain(this)
        setContent {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(bottom = 80.dp)) {
                drawTopAppBar()
            }
            Row (Modifier.fillMaxHeight(), verticalAlignment = Alignment.Bottom){
                showBottomNavigationBar()
            }
        }
    }
}
