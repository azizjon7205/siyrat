package uz.bismillah.siyrat.presentation.cases

import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import dagger.hilt.android.AndroidEntryPoint
import uz.bismillah.siyrat.R
import uz.bismillah.siyrat.data.resourse.network.response.Case
import uz.bismillah.siyrat.databinding.FragmentCasesBinding
import uz.bismillah.siyrat.presentation.cases.adapter.CasesAdapter
import uz.bismillah.siyrat.utils.extensions.invisible
import uz.bismillah.siyrat.utils.extensions.navigateSafe

@AndroidEntryPoint
class CasesFragment : BaseCasesFragment<FragmentCasesBinding>(FragmentCasesBinding::inflate) {

    override fun onViewCreate() {
        setUpToolbar()
        initViews()
    }

    private fun initViews() {
        val casesAdapter = CasesAdapter()
        casesAdapter.submitList(getCases())
        casesAdapter.onClick = {
            navController.navigateSafe(R.id.action_casesFragment_to_hadithListForCasesFragment, bundleOf("path" to it.name))
        }
        binding.apply {
            rvCases.adapter = casesAdapter
        }
    }

    private fun setUpToolbar() {
        binding.toolbarLayoutCases.apply {
            tvTitle.text = "Payg’ambarimiz ﷺ holatlari"
            ivRight.invisible()
        }
    }

    override fun getToolbar(): Toolbar = binding.toolbarLayoutCases.toolbarLayout

    fun getCases(): List<Case> {
        var cases = listOf<Case>(
            Case("Xursandchilikda"),
            Case("Kambag’al bo’lganda"),
            Case("Yetim bo’lib qolganda")
        )
        return cases
    }

}