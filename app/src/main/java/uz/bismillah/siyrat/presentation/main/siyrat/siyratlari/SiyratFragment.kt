package uz.bismillah.siyrat.presentation.main.siyrat.siyratlari

import androidx.appcompat.widget.Toolbar
import dagger.hilt.android.AndroidEntryPoint
import uz.bismillah.siyrat.R
import uz.bismillah.siyrat.databinding.FragmentSiyratBinding
import uz.bismillah.siyrat.presentation.main.BaseMainFragment
import uz.bismillah.siyrat.presentation.main.siyrat.siyratlari.adapter.SiyratAdapter
import uz.bismillah.siyrat.presentation.main.siyrat.siyratlari.model.SiyratData

@AndroidEntryPoint
class SiyratFragment : BaseMainFragment<FragmentSiyratBinding>(FragmentSiyratBinding::inflate) {

    private val siyratAdapter by lazy { SiyratAdapter() }
    override fun onViewCreate() {
        binding.toolbarLayoutCases.tvTitle.text = resources.getString(R.string.all_siyratlar)
        siyratAdapter.submitList(
            listOf(
                SiyratData("Tug`ilish va isimlari", "date and name"),
                SiyratData("Oilasi", "oilasi"),
                SiyratData("Nasabi", "nasabi"),
                SiyratData("Shamoillari", "shamoil"),
                SiyratData("Xulqlari", "xulqlari"),
                SiyratData("Ovqatlanishi", "ovqatlanishi"),
                SiyratData("G`azotlari", "gazotlari"),
                SiyratData("Muhim sanalar", "sanalar")
            )
        )
        binding.rvCases.adapter = siyratAdapter
        siyratAdapter.setMoreBtnListener { data->

        }
    }

    override fun getToolbar(): Toolbar = binding.toolbarLayoutCases.toolbarLayout
}