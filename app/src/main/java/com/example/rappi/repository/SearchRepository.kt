package com.exmple.rappi.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.example.rappi.models.Restaurants
import com.example.rappi.requests.RecipeApiClient


class SearchRepository {

    companion object {
        private var instance:SearchRepository? = null

        fun getInstance():SearchRepository
        {
            if(instance==null)
            {
                instance = SearchRepository()
            }
            return this.instance!!
        }
    }

    private var mSearchApiClient = RecipeApiClient()

    private val mRestaurants= MediatorLiveData<List<Restaurants>>()

    constructor() {

        this.mSearchApiClient = RecipeApiClient.getInstance()
        initMediators()
    }


    private fun initMediators() {

        val searchApiSource = mSearchApiClient.mSearch

        searchApiSource?.let {
            mRestaurants!!.addSource(it, object : Observer<List<Restaurants>> {
                override fun onChanged(t: List<Restaurants>?) {

                    if (t!=null)
                    {
                        mRestaurants.value= t
                    }
                }

            }) }

    }

    fun getRest(): LiveData<List<Restaurants>>?
    {
        return mSearchApiClient.getSearch()
    }

    fun mSearchRestApi()
    {
        mSearchApiClient.searchRestaurantsApi()
    }


}