package uz.bismillah.siyrat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.bismillah.siyrat.databinding.ActivityMainBinding
import uz.bismillah.siyrat.utils.extensions.gone
import uz.bismillah.siyrat.utils.extensions.visible

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainNavFragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        setupWithNavController(binding.bottomNavigationView, navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.mainFragment, R.id.casesFragment, R.id.settingsFragment -> binding.bottomNavigationView.visible()
                else -> binding.bottomNavigationView.gone()
            }
        }
    }
}