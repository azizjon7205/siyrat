package uz.bismillah.siyrat.presentation.main

import androidx.appcompat.widget.Toolbar
import dagger.hilt.android.AndroidEntryPoint
import uz.bismillah.siyrat.R
import uz.bismillah.siyrat.databinding.FragmentMainBinding
import uz.bismillah.siyrat.utils.extensions.navigateSafe

@AndroidEntryPoint
class MainFragment : BaseMainFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    override fun onViewCreate() {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setUpToolbar()
        initViews()
    }

    private fun initViews() {
        binding.btnYes.setOnClickListener {
            navController.navigateSafe(R.id.action_mainFragment_to_detailsInfoFragment)
        }
    }

    private fun setUpToolbar(){
        binding.toolbarFragment.apply {
            tvTitle.text = "Shanba, 23 Sentyabr 2023"
        }
    }

    override fun getToolbar(): Toolbar = binding.toolbarFragment.toolbarLayout

    override fun onDetach() {
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        super.onDetach()
    }

    override fun onStop() {
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        super.onStop()
    }
    private fun setUpToolbar(){
        binding.toolbarFragment.apply {
            tvTitle.text = "Shanba, 23 Sentyabr 2023"
            ivRight.setOnClickListener {
                // TODO: Remove following line later, it  is just for testing
                navController.navigateSafe(R.id.action_mainFragment_to_dailyHadithFragment)
            }
        }
    }

    override fun getToolbar(): Toolbar = binding.toolbarFragment.toolbarLayout

    override fun onDetach() {
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        super.onDetach()
    }

    override fun onStop() {
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        super.onStop()
    }
}