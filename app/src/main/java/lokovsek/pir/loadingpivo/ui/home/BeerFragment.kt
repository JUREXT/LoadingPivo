package lokovsek.pir.loadingpivo.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lokovsek.pir.loadingpivo.R

class BeerFragment : Fragment() {

    companion object {
        fun newInstance() = BeerFragment()
    }

    private lateinit var viewModel: BeerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.beer_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BeerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}