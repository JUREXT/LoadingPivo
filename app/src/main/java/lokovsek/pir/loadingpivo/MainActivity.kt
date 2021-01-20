package lokovsek.pir.loadingpivo

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import lokovsek.pir.loadingpivo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.nav_host_fragment)
        bottomNavigationView = binding.navView;
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_ale -> {
                    navController.navigate(R.id.beerFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_stouts -> {
                    navController.navigate(R.id.beerFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_red_ale -> {
                    navController.navigate(R.id.beerFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

}