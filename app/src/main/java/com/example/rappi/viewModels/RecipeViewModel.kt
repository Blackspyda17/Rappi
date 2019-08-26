
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.rappi.models.Category


class RecipeViewModel: ViewModel() {

     var mRecipeRepository = RecipeRepository()
     var mDidRetreiveRecipe:Boolean = false

    fun RecipeViewModel()
    {
        mRecipeRepository = RecipeRepository.getInstance()
        mDidRetreiveRecipe=false
    }

    public fun getRecipe(): LiveData<List<Category>>?
    {
        return mRecipeRepository.getRecipe()
    }

    fun setRetrievedRecipe(retrievedRecipe: Boolean) {
        mDidRetreiveRecipe = retrievedRecipe
    }

    fun didRetrieveRecipe(): Boolean {
        return mDidRetreiveRecipe
    }
    fun searchRecipesApi()
    {
        mRecipeRepository.searchRecipesApi()
    }
}