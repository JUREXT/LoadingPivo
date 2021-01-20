package lokovsek.pir.loadingpivo.api.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Rating(

    @Expose
    @SerializedName("average")
    val average: Double? = null,

    @Expose
    @SerializedName("reviews")
    val reviews: Double? = null,

    ) {
    override fun toString(): String {
        return "Beer(average=$average, reviews=$reviews)"
    }
}