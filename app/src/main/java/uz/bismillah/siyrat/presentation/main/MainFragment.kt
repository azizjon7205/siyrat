package uz.bismillah.siyrat.presentation.main

import dagger.hilt.android.AndroidEntryPoint
import uz.bismillah.siyrat.databinding.FragmentMainBinding

@AndroidEntryPoint
class MainFragment : BaseMainFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    override fun onViewCreate() {
        initViews()
    }

    private fun initViews(){

    }
}