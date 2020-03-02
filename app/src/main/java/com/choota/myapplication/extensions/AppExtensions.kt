package com.choota.myapplication.extensions

import android.app.Activity
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import androidx.lifecycle.ViewModelProvider
import com.choota.myapplication.activities.main.MainViewModel
import kotlin.reflect.KClass

fun ImageView.load(url: Any) {
    Glide.with(this.context)
        .load(url)
        .into(this)
}
