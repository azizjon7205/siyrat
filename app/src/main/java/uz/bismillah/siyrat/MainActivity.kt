package uz.bismillah.siyrat

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.navigateUp
import dagger.hilt.android.AndroidEntryPoint
import uz.bismillah.siyrat.data.resourse.local.data_store.SharedPreferencesHelper
import uz.bismillah.siyrat.databinding.ActivityMainBinding
import uz.bismillah.siyrat.utils.Constants.PREF_APP_THEME_MODE
import uz.bismillah.siyrat.utils.extensions.gone
import uz.bismillah.siyrat.utils.extensions.visible
import uz.bismillah.siyrat.utils.setChangeAppTheme

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    val appBarConfiguration by lazy {
        AppBarConfiguration(
            setOf(
                R.id.mainFragment,
                R.id.casesFragment,
                R.id.settingsFragment
            )
        )
    }

    private val sharedPref by lazy { SharedPreferencesHelper(context = this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setChangeAppTheme(sharedPref)
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

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        when (navController.currentDestination?.id) {
            R.id.mainFragment -> super.onBackPressed()
            else -> {
                navController.navigateUp(appBarConfiguration)
            }
        }
    }

    override fun onStop() {
        sharedPref.preferences.unregisterOnSharedPreferenceChangeListener(this)
        super.onStop()
    }

    override fun onSharedPreferenceChanged(p0: SharedPreferences?, key: String?) {
        when (key) {
            PREF_APP_THEME_MODE -> {
                setChangeAppTheme(sharedPref)
            }
        }
    }
}