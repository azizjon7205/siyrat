package uz.bismillah.siyrat.presentation.settings

import androidx.appcompat.widget.Toolbar
import dagger.hilt.android.AndroidEntryPoint
import uz.bismillah.siyrat.R
import uz.bismillah.siyrat.databinding.FragmentSettingsBinding
import uz.bismillah.siyrat.utils.ThemeModeState
import uz.bismillah.siyrat.utils.extensions.invisible
import uz.bismillah.siyrat.utils.setChangeAppTheme

@AndroidEntryPoint
class SettingsFragment :
    BaseSettingsFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {

    override fun onViewCreate() {
        setUpToolbar()
        initViews()
    }

    private fun initViews() {
        binding.apply {
            themeSwitchBtn.isChecked = (shared.getTheme() == ThemeModeState.DARK.name)
            themeSwitchBtn.setOnCheckedChangeListener { _, _ ->
                shared.setTheme(if (themeSwitchBtn.isChecked) ThemeModeState.DARK.name else ThemeModeState.LIGHT.name)
                setChangeAppTheme(shared)
            }
        }
    }

    private fun setUpToolbar() {
        binding.toolbarSettings.apply {
            ivRight.invisible()
            tvTitle.text = resources.getString(R.string.settings)
        }
    }

    override fun getToolbar(): Toolbar = binding.toolbarSettings.toolbarLayout
}