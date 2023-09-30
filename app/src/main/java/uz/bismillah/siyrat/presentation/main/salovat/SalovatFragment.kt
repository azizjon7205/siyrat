package uz.bismillah.siyrat.presentation.main.salovat

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import dagger.hilt.android.AndroidEntryPoint
import uz.bismillah.siyrat.R
import uz.bismillah.siyrat.databinding.FragmentSalovatBinding
import uz.bismillah.siyrat.presentation.main.BaseMainFragment

@AndroidEntryPoint
class SalovatFragment : BaseMainFragment<FragmentSalovatBinding>(FragmentSalovatBinding::inflate) {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onViewCreate() {
        setUpToolbar()
        initViews()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpDrawerLayout()
        setUpToolbar()
    }

    private fun setUpDrawerLayout() {
        drawerLayout = requireActivity().findViewById(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(
            requireActivity(),
            drawerLayout,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        drawerLayout.addDrawerListener(toggle)
        // Enable the drawer indicator icon in the toolbar
        toggle.syncState()

        binding.toolbarFragment.ivRight.setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
                drawerLayout.closeDrawer(GravityCompat.END)
            } else {
                drawerLayout.openDrawer(GravityCompat.END)
            }
        }
    }

    private fun initViews() {

    }

    private fun setUpToolbar() {
        binding.toolbarFragment.apply {
            // Kerakli Title set qilinadi.
            tvTitle.isSelected = true
            tvTitle.text = "Keling birga salovat aytamiz"
            ivRight.setImageResource(R.drawable.ic_menu)
            // Right ga hohlagan iconkani set qilib yoki invisible, visible qilib, clickni boshqarsa bo`ladi.

        }
    }

    override fun getToolbar(): Toolbar? = binding.toolbarFragment.toolbarLayout
}