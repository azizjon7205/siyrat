package uz.bismillah.siyrat.presentation.main.salovat

import androidx.appcompat.widget.Toolbar
import dagger.hilt.android.AndroidEntryPoint
import uz.bismillah.siyrat.databinding.FragmentSalovatBinding
import uz.bismillah.siyrat.presentation.main.BaseMainFragment

@AndroidEntryPoint
class SalovatFragment : BaseMainFragment<FragmentSalovatBinding>(FragmentSalovatBinding::inflate) {

    override fun onViewCreate() {
        setUpToolbar()
        initViews()
    }

    private fun initViews() {

    }

    private fun setUpToolbar() {

    }

    override fun getToolbar(): Toolbar? = null
}