package lokovsek.pir.loadingpivo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import lokovsek.pir.loadingpivo.api.dto.Beer
import lokovsek.pir.loadingpivo.ui.repository.Repository

class BeerViewModel : ViewModel() {

    private val _beerType: MutableLiveData<String> = MutableLiveData()
   // private val _beerData: MutableLiveData<List<Beer>> = MutableLiveData()

    val beerList: LiveData<List<Beer>> = Transformations.switchMap(_beerType) { beerType ->
        return@switchMap Repository.loadBeerList(beerType)
    }

    fun setBeerType(beerType: String) {
        if(_beerType.value == beerType) return
        _beerType.value = beerType
    }

    fun cancelLoadBeerJob() {
        Repository.cancelLoadBeerJob()
    }
}