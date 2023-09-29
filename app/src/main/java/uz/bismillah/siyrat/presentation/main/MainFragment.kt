package uz.bismillah.siyrat.presentation.main

import androidx.appcompat.widget.Toolbar
import dagger.hilt.android.AndroidEntryPoint
import uz.bismillah.siyrat.R
import uz.bismillah.siyrat.databinding.FragmentMainBinding
import uz.bismillah.siyrat.utils.extensions.navigateSafe

@AndroidEntryPoint
class MainFragment : BaseMainFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    override fun onViewCreate() {
        initViews()
    }

    private fun initViews() {
        binding.tvTitle.setOnClickListener {
            navController.navigateSafe(R.id.action_mainFragment_to_detailsInfoFragment)
        }
    }

    override fun getToolbar(): Toolbar? = null
}