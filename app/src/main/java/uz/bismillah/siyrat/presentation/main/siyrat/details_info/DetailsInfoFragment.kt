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
                "Dalil ipsum dolor sit amet consectetur. Amet eros feugiat arcu pellentesque aliquam."
            tvLongInfo.text =
                "Lorem ipsum dolor sit amet consectetur. Tortor vestibulum tristique mauris amet egestas nunc sed volutpat nisl. Non nibh elementum id nascetur iaculis. Eu ut ullamcorper ut dictum morbi hendrerit suspendisse. Sed scelerisque amet nunc feugiat nibh. \n\n" +
                        "Semper ut tortor condimentum lorem. Tincidunt tempus velit aliquam nibh non sed. Aliquet viverra elementum massa integer. Venenatis nec malesuada neque amet maecenas ullamcorper donec. Vitae lacinia cursus est id et ridiculus et ut. Pellentesque faucibus gravida egestas.\n\n" +
                        "Semper ut tortor condimentum lorem. Tincidunt tempus velit aliquam nibh non sed. Aliquet viverra elementum massa integer. Venenatis nec malesuada neque amet maecenas ullamcorper donec. Vitae lacinia cursus est id et ridiculus et ut. Pellentesque faucibus gravida egestas.\n\n" +
                        "Semper ut tortor condimentum lorem. Tincidunt tempus velit aliquam nibh non sed. Aliquet viverra elementum massa integer. Venenatis nec malesuada neque amet maecenas ullamcorper donec. Vitae lacinia cursus est id et ridiculus et ut. Pellentesque faucibus gravida egestas.\n\n" +
                        "Semper ut tortor condimentum lorem. Tincidunt tempus velit aliquam nibh non sed. Aliquet viverra elementum massa integer. Venenatis nec malesuada neque amet maecenas ullamcorper donec. Vitae lacinia cursus est id et ridiculus et ut. Pellentesque faucibus gravida egestas.\n\n" +
                        "Semper ut tortor condimentum lorem. Tincidunt tempus velit aliquam nibh non sed. Aliquet viverra elementum massa integer. Venenatis nec malesuada neque amet maecenas ullamcorper donec. Vitae lacinia cursus est id et ridiculus et ut. Pellentesque faucibus gravida egestas.\n\n" +
                        "Semper ut tortor condimentum lorem. Tincidunt tempus velit aliquam nibh non sed. Aliquet viverra elementum massa integer. Venenatis nec malesuada neque amet maecenas ullamcorper donec. Vitae lacinia cursus est id et ridiculus et ut. Pellentesque faucibus gravida egestas."
        }
    }

    private fun setUpToolbar() {
        binding.toolbarFragment.apply {
            // Kerakli Title set qilinadi.
            tvTitle.isSelected = true
            tvTitle.text = "Lorem impsum dolor sit amit iofhiouhe"
            // Right ga hohlagan iconkani set qilib yoki invisible, visible qilib, clickni boshqarsa bo`ladi.
            ivRight.setOnClickListener {

            }
        }
    }

    override fun getToolbar(): Toolbar = binding.toolbarFragment.toolbarLayout
}