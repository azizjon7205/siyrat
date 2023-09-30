package uz.bismillah.siyrat.presentation.main.salovat

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import uz.bismillah.siyrat.R
import uz.bismillah.siyrat.data.resourse.local.room.Salovat
import uz.bismillah.siyrat.databinding.FragmentSalovatBinding
import uz.bismillah.siyrat.presentation.cases.adapter.SalovatAdapter
import uz.bismillah.siyrat.presentation.main.BaseMainFragment

@AndroidEntryPoint
class SalovatFragment : BaseMainFragment<FragmentSalovatBinding>(FragmentSalovatBinding::inflate) {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    var listSalovat: List<Salovat> = listOf()
    lateinit var adapter: SalovatAdapter
    val viewModel: SalovatViewModel by viewModels()
    override fun onViewCreate() {
        setUpToolbar()
        initViews()
        viewModel.getAllSalovat()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpDrawerLayout()
        setUpToolbar()
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.countToday.observe(this.viewLifecycleOwner) { todayCount ->
            binding.mainCounter.text = todayCount.toString()
        }

        viewModel.countAll.observe(this.viewLifecycleOwner) { allCount ->
            binding.dailyCounter.text = allCount.toString()
        }
        viewModel.salovatList.observe(this.viewLifecycleOwner) {
            listSalovat = it
            adapter.submitList(listSalovat)
            Log.d("TTTT", "setUpObservers:${listSalovat.size} ")
        }

        viewModel.activeSalovat.observe(this.viewLifecycleOwner) { activeSalovat ->
            binding.apply {
                arabicText.text = activeSalovat.arabicText
                uzbekText.text = activeSalovat.uzbekText
                dailyCounter.text = activeSalovat.allCount.toString()
            }
        }

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
        adapter = SalovatAdapter()
        Log.d("TTTT", "initViews: ${listSalovat.size}")
        adapter.submitList(listSalovat)
        binding.apply {
            rvSalovat.layoutManager = LinearLayoutManager(requireContext())
            rvSalovat.adapter = adapter
        }
        adapter.onClick = { salovat, id ->
            Log.d("TTTT", "id: $id")
            viewModel.changeActiveSalovat(id)
            viewModel.counter = 0
            viewModel.setZero()
            drawerLayout.closeDrawer(GravityCompat.END)

        }
        binding.ivOptions.setOnClickListener {
            viewModel.counter = 0
            viewModel.setZero()
        }

        binding.layoutCounter.setOnClickListener {
//            it.performClick()
              viewModel.count()
        }

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