package com.example.simpleapp

import android.util.Log
fun String.logD(){
    LogHelper.logD(msg = this)
}
object LogHelper {
    val TAG = "LogHelper"
    fun logD(tag: String = TAG, msg: String) {
        Log.d(tag, msg)
    }

}