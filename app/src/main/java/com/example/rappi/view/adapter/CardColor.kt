package com.example.rappi.view.adapter

import android.graphics.Color
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter

object CardColor {

    @BindingAdapter("    app:cardColor")
    @JvmStatic
    fun setColor(view: CardView, rating: String) {
        val rate = rating.toFloat()
        if (rate >= 3) {
            view.setCardBackgroundColor(Color.parseColor("#4CAF50"))
        } else if (rate >= 2 && rate < 3) {
            view.setCardBackgroundColor(Color.parseColor("#C8FFA500"))
        } else
            view.setCardBackgroundColor(Color.parseColor("#B5F44336"))
    }
}