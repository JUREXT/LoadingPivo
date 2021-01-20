package lokovsek.pir.loadingpivo.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import lokovsek.pir.loadingpivo.databinding.BeerFragmentBinding
import timber.log.Timber

class BeerFragment : Fragment() {

    companion object {
        fun newInstance() = BeerFragment()
    }

    private var _binding: BeerFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: BeerViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = BeerFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BeerViewModel::class.java)
        val beerType = arguments?.let { BeerFragmentArgs.fromBundle(it).beerType }
        Timber.d("Beer Type: %s", beerType)

        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                if (beerType != null) {
                   val data = viewModel.setBeerType(beerType)
                }
            }
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