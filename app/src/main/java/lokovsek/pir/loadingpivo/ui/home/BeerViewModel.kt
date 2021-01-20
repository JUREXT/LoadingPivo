package lokovsek.pir.loadingpivo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import lokovsek.pir.loadingpivo.api.dto.Beer
import lokovsek.pir.loadingpivo.repository.Repository

class BeerViewModel : ViewModel() {

    fun getBeerData(beerType: String): LiveData<List<Beer>> {
        return Repository.loadBeerList(beerType)
    }

    fun cancelLoadBeerJob() {
        Repository.cancelLoadBeerJob()
    }
}