package lokovsek.pir.loadingpivo.ui.repository

import lokovsek.pir.loadingpivo.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_BEER)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiService: Api by lazy {
        retrofitBuilder
            .build()
            .create(Api::class.java)
    }

}