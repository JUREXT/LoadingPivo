package lokovsek.pir.loadingpivo.api

import lokovsek.pir.loadingpivo.api.dto.Beer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("beers/{beerType}")
    suspend fun loadBeerList(@Path("beerType") beerType: String) : List<Beer>
}