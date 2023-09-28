package uz.bismillah.siyrat.presentation.settings

import dagger.hilt.android.AndroidEntryPoint
import uz.bismillah.siyrat.databinding.FragmentSettingsBinding

@AndroidEntryPoint
class SettingsFragment : BaseSettingsFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {

    override fun onViewCreate() {
        initViews()
    }

    private fun initViews() {

    }
}