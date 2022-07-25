package uz.javokhirdev.photoplay.core.extensions

import android.util.Log

fun Any?.logd() {
    Log.d("LOG_TAG", this.toString())
}