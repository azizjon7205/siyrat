package uz.bismillah.siyrat.presentation.main.siyrat.details_info

import androidx.appcompat.widget.Toolbar
import dagger.hilt.android.AndroidEntryPoint
import uz.bismillah.siyrat.databinding.FragmentDetailsInfoBinding
import uz.bismillah.siyrat.presentation.main.BaseMainFragment
import uz.bismillah.siyrat.presentation.main.home.model.MainHadith

@AndroidEntryPoint
class DetailsInfoFragment :
    BaseMainFragment<FragmentDetailsInfoBinding>(FragmentDetailsInfoBinding::inflate) {

    lateinit var mainHadith: MainHadith

    override fun onViewCreate() {
        arguments?.let { data ->
            mainHadith = data.getParcelable("MainHadith")!!
        }
        setUpToolbar()
        initViews()
    }

    private fun initViews() {
        binding.apply {
            tvInfo.text = mainHadith.name
            tvShortInfo.text = mainHadith.arabic
            tvLongInfo.text = mainHadith.uzbek
        }
    }

    private fun setUpToolbar() {
        binding.toolbarFragment.apply {
            // Kerakli Title set qilinadi.
            tvTitle.isSelected = true
            tvTitle.text = mainHadith.name
            // Right ga hohlagan iconkani set qilib yoki invisible, visible qilib, clickni boshqarsa bo`ladi.
            ivRight.setOnClickListener {

            }
        }
    }

    override fun getToolbar(): Toolbar = binding.toolbarFragment.toolbarLayout
}