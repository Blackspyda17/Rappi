

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.rappi.models.Restaurants
import com.exmple.rappi.repository.SearchRepository


class RestaurantsViewModel: ViewModel() {

    var mSearchRepository = SearchRepository()

    var mDidRetreiveRest:Boolean = false

    fun RestaurantsViewModel()
    {
        mSearchRepository = SearchRepository.getInstance()

        mDidRetreiveRest = false

    }

    fun getRest(): LiveData<List<Restaurants>>?
    {
        return mSearchRepository.getRest()
    }

    fun setRetrievedRest(retrievedRest:Boolean)
    {
        mDidRetreiveRest = retrievedRest
    }

    fun searchRestApi()
    {
        mSearchRepository.mSearchRestApi()
    }





}