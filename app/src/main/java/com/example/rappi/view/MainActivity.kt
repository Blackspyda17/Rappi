package com.example.rappi.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import com.example.rappi.R
import com.example.rappi.models.Restaurants
import com.example.rappi.view.adapter.RecyclerAdapter1
import com.example.rappi.viewModels.RecipeViewModel
import com.example.rappi.viewModels.RestaurantsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    private var mRestaurantsViewModel: RestaurantsViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


        window.statusBarColor = resources.getColor(R.color.white)

        // mRecipeViewModel = ViewModelProviders.of(this).get(RecipeViewModel::class.java)
        mRestaurantsViewModel = ViewModelProviders.of(this).get(RestaurantsViewModel::class.java)

        var imageList = arrayOf<Int>(
            R.drawable.newimage1,
            R.drawable.newimage2,
            R.drawable.newimage3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9
        )

        subscribeObservers(imageList)
        mRestaurantsViewModel!!.searchRestApi()

        // mRecipeViewModel!!.searchRecipesApi()

        lunchboxLayout.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)

        }



        bottomMenu.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                /*  R.id.nearme -> {

                      //to do
                      true
                  }
                  R.id.explore -> {
                      //to do
                      true
                  }
                  R.id.cart -> {
                      //to do
                      true
                  }*/

                R.id.account -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }


    }

    override fun onResume() {
        super.onResume()
        bottomMenu.menu.getItem(0).setChecked(true)

    }


    private fun subscribeObservers(imageList: Array<Int>) {

        Log.i("check", "working1")


        mRestaurantsViewModel!!.getRest()
        mRestaurantsViewModel!!.getRest()!!.observe(
            this,
            Observer<List<Restaurants>> { t: List<Restaurants>? ->
                if (t != null) {
                    Log.i("Check", t.get(0).restaurant!!.name)


                    val adapter = RecyclerAdapter1(t, imageList, this)
                    recyclerView.adapter = adapter



                    if (t.equals(mRestaurantsViewModel!!.getRest())) {
                        mRestaurantsViewModel!!.setRetrievedRest(true)
                    }
                } else {
                    Log.i("Status", "Failed")
                }
            })
    }


}
