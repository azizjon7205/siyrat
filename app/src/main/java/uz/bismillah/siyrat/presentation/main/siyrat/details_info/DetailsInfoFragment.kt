package uz.bismillah.siyrat.presentation.main.siyrat.details_info

import androidx.appcompat.widget.Toolbar
import dagger.hilt.android.AndroidEntryPoint
import uz.bismillah.siyrat.databinding.FragmentDetailsInfoBinding
import uz.bismillah.siyrat.presentation.main.BaseMainFragment

@AndroidEntryPoint
class DetailsInfoFragment :
    BaseMainFragment<FragmentDetailsInfoBinding>(FragmentDetailsInfoBinding::inflate) {

    override fun onViewCreate() {
        setUpToolbar()
        initViews()
    }

    private fun initViews() {
        binding.apply {
            tvInfo.text = "1-Hadis"
            tvShortInfo.text =
                "Dalil ipsum dolor sit amet consectetur."
            tvLongInfo.text =
                "Lorem ipsum dolor sit amet consectetur."
        }
    }

    private fun setUpToolbar() {
        binding.toolbarFragment.apply {
            // Kerakli Title set qilinadi.
            tvTitle.isSelected = true
            tvTitle.text = "Lorem impsum dolor sit amit"
            // Right ga hohlagan iconkani set qilib yoki invisible, visible qilib, clickni boshqarsa bo`ladi.
            ivRight.setOnClickListener {

            }
        }
    }

    override fun getToolbar(): Toolbar = binding.toolbarFragment.toolbarLayout
}