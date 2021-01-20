package lokovsek.pir.loadingpivo.ui.repository

import lokovsek.pir.loadingpivo.ui.repository.dto.Beer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("beers/{beerType}")
    suspend fun fetchBeerList(@Path("beerType") beerType: String) : Call<List<Beer>>
}