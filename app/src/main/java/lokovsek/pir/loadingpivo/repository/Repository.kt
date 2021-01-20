package lokovsek.pir.loadingpivo.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.*
import lokovsek.pir.loadingpivo.api.RetrofitBuilder
import lokovsek.pir.loadingpivo.api.dto.Beer

object Repository {

    var loadBeersJob: CompletableJob? = null

    fun loadBeerList(beerType: String): LiveData<List<Beer>> {
        loadBeersJob = Job()
        return object : LiveData<List<Beer>>() {
            override fun onActive() {
                loadBeersJob?.let { theJob ->
                    CoroutineScope(Dispatchers.IO + theJob).launch {
                        val beerData = RetrofitBuilder.apiService.loadBeerList(beerType)
                        withContext(Dispatchers.Main) {
                            value = beerData
                            theJob.isCompleted
                        }
                    }
                }
            }
        }
    }

    fun cancelLoadBeerJob() {
        loadBeersJob?.cancel()
    }
}