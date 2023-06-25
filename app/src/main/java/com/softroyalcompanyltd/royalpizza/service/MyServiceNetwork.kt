package com.softroyalcompanyltd.royalpizza.service

import android.app.Service
import android.content.Intent
import android.net.ConnectivityManager
import android.os.IBinder
import android.widget.Toast
import com.softroyalcompanyltd.royalpizza.MAIN_INSTANCE
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MyServiceNetwork : Service() {

    private var flag : Boolean = true

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        CoroutineScope(Dispatchers.Main).launch {
            checkConnection()
        }
        return START_STICKY
    }

    override fun onDestroy() {
        flag = false
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }
    private suspend fun checkConnection () {
        while (flag) {
            delay(5000)
            val cs = CONNECTIVITY_SERVICE
            val cm = getSystemService(cs) as ConnectivityManager
            if (cm.activeNetworkInfo?.isConnected == true) {

            } else {
                Toast.makeText(MAIN_INSTANCE, "Check your network connection", Toast.LENGTH_SHORT).show()
            }
        }
    }
}