package lokovsek.pir.loadingpivo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import lokovsek.pir.loadingpivo.R
import lokovsek.pir.loadingpivo.api.dto.Beer
import lokovsek.pir.loadingpivo.utils.roundValue
import timber.log.Timber

class BeerListAdapter(private val list: List<Beer>, private val ctx: Context) : RecyclerView.Adapter<BeerListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return BeerListViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BeerListViewHolder, position: Int) {
        val item: Beer = list[position]
        holder.bind(item, ctx)

        holder.itemView.setOnClickListener {
            Timber.d("Click Item: %s", item.toString())
        }
    }
}

class BeerListViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.beer_grid_item, parent, false)) {
    var beerImage: ImageView? = null
    var beerNameTv: TextView? = null
    var beerPriceTv: TextView? = null
    var beerRatingTv: TextView? = null

    init {
        beerImage = itemView.findViewById(R.id.image_view_preview)
        beerNameTv = itemView.findViewById(R.id.text_view_beer_name)
        beerPriceTv = itemView.findViewById(R.id.text_view_price)
        beerRatingTv = itemView.findViewById(R.id.text_view_rating)
    }

    fun bind(item: Beer, ctx: Context) {
        beerImage?.let { Glide.with(ctx).load(item.image).centerCrop().placeholder(R.drawable.ic_dashboard_black_24dp).into(beerImage!!) };
        beerNameTv?.text = item.name
        beerPriceTv?.text = item.price
        beerRatingTv?.text = roundValue(item.rating?.average, 2).toString()
    }

}
