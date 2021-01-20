package lokovsek.pir.loadingpivo.ui.repository.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Beer(

    @Expose
    @SerializedName("price")
    val price: String? = null,

    @Expose
    @SerializedName("name")
    val name: String? = null,

    @Expose
    @SerializedName("rating")
    val rating: Rating? = null,

    @Expose
    @SerializedName("image")
    val image: String? = null,

    @Expose
    @SerializedName("id")
    val id: Long? = null,

    ) {
    override fun toString(): String {
        return "Beer(id=$id, name=$name, rating=$rating, image=$image, price=$price)"
    }
}