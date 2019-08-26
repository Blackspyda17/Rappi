package com.example.rappi.response

import com.example.rappi.models.Category
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CategoryResponse {

    @SerializedName("categories")
    @Expose
    private val categories: List<Category>? = null

    fun getRecipes(): List<Category>? {
        return categories
    }


    override fun toString(): String {
        return "CategoriesResponsse{" +
                "categoriess="+categories+'}'
    }

}