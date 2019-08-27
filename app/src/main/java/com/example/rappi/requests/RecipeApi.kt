package com.example.rappi.requests
import com.example.rappi.response.CategoryResponse
import com.example.rappi.response.SearchResponse
import retrofit2.Call
import retrofit2.http.*

interface RecipeApi {


    //for getting categories
    @Headers("user_key: 8ec0633e08ec5643b779767fa37f2d88")
    @GET("api/v2.1/categories")
    fun searchCategories():Call<CategoryResponse>


    //for getting all details of restaurant using cityid or lattitude and longitude and collection id
    @Headers("user_key: 8ec0633e08ec5643b779767fa37f2d88")
    @GET("api/v2.1/search")
    fun searchApi(@Query("lat") queryParameters1: String,
                  @Query("lon")queryParams2: String,
                  @Query("sort")queryParams3: String):Call<SearchResponse>





}