package com.example.rappi.view.adapter


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapter {
    @BindingAdapter("app:setImage")
    @JvmStatic
    fun setImage(view: ImageView, imageUrl: String) {
        if (imageUrl.isEmpty()) {

        } else {
            Glide.with(view.context).load(imageUrl).into(view)

        }
    }

}