package lokovsek.pir.loadingpivo.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lokovsek.pir.loadingpivo.adapters.BeerListAdapter
import lokovsek.pir.loadingpivo.api.dto.Beer
import lokovsek.pir.loadingpivo.databinding.BeerFragmentBinding
import timber.log.Timber

class BeerFragment : Fragment() {

    companion object {
        fun newInstance() = BeerFragment()
    }

    private var _binding: BeerFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: BeerViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = BeerFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BeerViewModel::class.java)
        val beerType = arguments?.let { BeerFragmentArgs.fromBundle(it).beerType }
        Timber.d("Beer Type: %s", beerType)
        setAdapterData(beerType)
    }

    private fun setAdapterData(beerType: String?) {
        binding.materialProgressBar.visibility =  View.VISIBLE
        if (beerType != null) {
            viewModel.getBeerData(beerType).observe(viewLifecycleOwner, Observer {
                binding.materialProgressBar.visibility =  View.INVISIBLE
                Timber.d("""Data Size: ${it.size} For Beer Type: $beerType""")
                for (beer in it) {
                    //Timber.d("Beer: %s", beer.toString())
                   // Timber.d("Rank; %s", beer.rating?.average)
                }
                setupRecyclerView(it)
            })
        }
    }

    private fun setupRecyclerView(list: List<Beer>) {

        binding.recyclerViewList.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = activity?.let { BeerListAdapter(list, it) }
        }
    }

    override fun onDestroy() {
        viewModel.cancelLoadBeerJob()
        super.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}