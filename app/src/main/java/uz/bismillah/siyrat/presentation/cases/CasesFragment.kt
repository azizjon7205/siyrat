package uz.bismillah.siyrat.presentation.cases

import dagger.hilt.android.AndroidEntryPoint
import uz.bismillah.siyrat.databinding.FragmentCasesBinding

@AndroidEntryPoint
class CasesFragment : BaseCasesFragment<FragmentCasesBinding>(FragmentCasesBinding::inflate) {

    override fun onViewCreate() {
        initViews()
    }

    private fun initViews() {

    }
}