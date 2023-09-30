package uz.bismillah.siyrat.presentation.main.home

import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint
import uz.bismillah.siyrat.R
import uz.bismillah.siyrat.databinding.FragmentMainBinding
import uz.bismillah.siyrat.presentation.main.BaseMainFragment
import uz.bismillah.siyrat.presentation.main.home.adapter.VPMainHadithAdapter
import uz.bismillah.siyrat.presentation.main.home.model.MainHadith
import uz.bismillah.siyrat.utils.ThemeModeState
import uz.bismillah.siyrat.utils.extensions.navigateSafe
import java.util.Timer
import java.util.TimerTask

@AndroidEntryPoint
class MainFragment : BaseMainFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val mainHadithAdapter by lazy { VPMainHadithAdapter() }
    private var position: Int = 0
    private var timer: Timer? = null
    private var timerTask: TimerTask? = null
    private lateinit var layoutManagerBanner: LinearLayoutManager

    companion object {
        const val DELAY_MS: Long = 2500 //delay in milliseconds before task is to be executed
        const val PERIOD_MS: Long = 5000 // time in milliseconds between successive task executions.
    }

    override fun onViewCreate() {
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setUpToolbar()
        initViews()
    }

    private fun initViews() {
        setUpMainHadith()
        binding.apply {
            ivBackground.setImageResource(
                if (shared.getTheme() == ThemeModeState.LIGHT.name) R.drawable.tropical
                else R.drawable.tropical_night
            )
            btnYes.setOnClickListener {
                navController.navigateSafe(R.id.action_mainFragment_to_detailsInfoFragment)
            }
            llLetSayHello.tvTitle.text = resources.getString(R.string.let_is_say_hello)
        }
    }

    private fun setUpMainHadith() {
        val fireStore: FirebaseFirestore = FirebaseFirestore.getInstance()
        val case = fireStore.collection("xadislar")

        mainHadithAdapter.submitList(
            listOf(
                MainHadith(
                    name = "namoz",
                    uzbek = "Abdulloh Ibn Umar raziyallohu anhumodan, Rasululloh sallallohu alayhi va sallam dedilar",
                    arabic = "عن عبد الله بن عمر رضي الله عنهما قال: قال رسول الله صلى الله عليه وسلم: صلاة الجماعة تفضل صلاة الفرد بسبع وعشرين درجة. \n"
                ),
                MainHadith(
                    name = "safar",
                    uzbek = "Abu Said Xudriy raziyallohu anhudan, Rasululloh sallallohu alayhi va sallam dedilar",
                    arabic = "عن أبي سعيد الخدري رضي الله عنه قال: قال رسول الله صلى الله عليه وسلم: لا تشد الرحال إلا إلى ثلاثة مساجد: المسجد الحرام ومسجد الأقصى ومسجدي هذا.\n"
                ),
                MainHadith(
                    name = "buyruqlar",
                    uzbek = "Abu Hurayra raziyallohu anhudan rivoyat qilinadi: Doʻstim( sallallohu alayhi va sallam) menga uch narsani vasiyat qildilar",
                    arabic = "ن أبي هريرة رضي الله عنه قال: أوصاني خليلي صلى الله عليه وسلم بثلاث: صيام ثلاثة أيام من كل شهر، وركعتي الضحى، وأن أوتر قبل أن أنام."
                )
            )
        )
        binding.apply {
            layoutManagerBanner =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvMainHadith.layoutManager = layoutManagerBanner
            rvMainHadith.adapter = mainHadithAdapter
        }
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.rvMainHadith)
        binding.dotsIndicator.attachToRecyclerView(binding.rvMainHadith)
        binding.rvMainHadith.apply {
            smoothScrollBy(5, 0)
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    position = layoutManagerBanner.findLastCompletelyVisibleItemPosition()
                }
            })
        }
    }

    private fun runAutoScrollBanner() {
        if (timer == null && timerTask == null) {
            timer = Timer()
            timerTask = object : TimerTask() {
                override fun run() {
                    if (position == mainHadithAdapter.itemCount - 1) {
                        position = 0
                        binding.rvMainHadith.smoothScrollToPosition(position)
                    } else {
                        binding.rvMainHadith.smoothScrollToPosition(++position)
                    }
                }
            }
            timer!!.schedule(timerTask, DELAY_MS, PERIOD_MS)
        }
    }

    private fun stopAutoScrollBanner() {
        if (timer != null && timerTask != null) {
            timer!!.cancel()
            timer = null
            timerTask!!.cancel()
            timerTask = null
            position = layoutManagerBanner.findFirstCompletelyVisibleItemPosition()
        }
    }

    private fun setUpToolbar() {
        binding.toolbarFragment.apply {
            tvTitle.text = "Shanba, 23 Sentyabr 2023"
            ivRight.setOnClickListener {
                // TODO: Remove following line later, it  is just for testing
                navController.navigateSafe(R.id.action_mainFragment_to_dailyHadithFragment)
            }
        }
    }

    override fun getToolbar(): Toolbar = binding.toolbarFragment.toolbarLayout

    override fun onResume() {
        runAutoScrollBanner()
        super.onResume()
    }

    override fun onPause() {
        stopAutoScrollBanner()
        super.onPause()
    }

    override fun onDetach() {
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        super.onDetach()
    }

    override fun onStop() {
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        super.onStop()
    }
}