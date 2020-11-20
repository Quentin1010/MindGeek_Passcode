package com.example.mindgeek_test.base

import android.view.View
import androidx.databinding.BindingAdapter

object BindingAdapters {

    @BindingAdapter("goneUnless")
    @JvmStatic
    fun setVisibility(view: View, boolean: Boolean) {
        view.visibility = if(boolean) View.VISIBLE else View.GONE
    }
}