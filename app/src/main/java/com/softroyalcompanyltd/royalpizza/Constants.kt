package com.softroyalcompanyltd.royalpizza

import com.softroyalcompanyltd.royalpizza.view.MainActivity

/////////////////////////////////Singleton objects
lateinit var MAIN_INSTANCE : MainActivity

fun objectInstanceMain(activity: MainActivity) {
    MAIN_INSTANCE = activity
}



