

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.example.rappi.models.Category
import com.example.rappi.requests.RecipeApiClient


class RecipeRepository {

    companion object {
        private var instance:RecipeRepository?  = null

        fun getInstance():RecipeRepository
        {
            if (instance==null)
            {
                instance = RecipeRepository()
            }
            return this.instance!!
        }
    }

    private var mRecipeApiClient = RecipeApiClient()

    private val mRecipes = MediatorLiveData<List<Category>>()

    constructor() {
        this.mRecipeApiClient = RecipeApiClient.getInstance()
        initMediators()
    }

    private fun initMediators() {

        val recipeApiSource = mRecipeApiClient.mRecipes

        recipeApiSource?.let {
            mRecipes.addSource(it, object : Observer<List<Category>> {
                override fun onChanged(t: List<Category>?) {

                    if (t!=null)
                    {
                        mRecipes.value = t
                    }
                    else
                    {

                    }
                }


            })
        }
    }

    public fun getRecipe(): LiveData<List<Category>>? {
        return mRecipeApiClient.getRecipe()
    }

    fun searchRecipesApi()
    {
        mRecipeApiClient.searchRecipesApi()
    }



}