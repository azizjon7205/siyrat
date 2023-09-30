package uz.bismillah.siyrat.presentation.main.daily_hadith

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.firebase.firestore.FirebaseFirestore
import uz.bismillah.siyrat.R
import uz.bismillah.siyrat.data.resourse.network.response.Hadith
import uz.bismillah.siyrat.databinding.FragmentDailyHadithBinding
import uz.bismillah.siyrat.presentation.main.BaseMainFragment
import java.util.Calendar


class DailyHadithFragment :
    BaseMainFragment<FragmentDailyHadithBinding>(FragmentDailyHadithBinding::inflate) {

    override fun onViewCreate() {
        setUpToolbar()
        initViews()
        fetchData()
    }

    private fun initViews() {
        binding.apply {

        }
    }

    private fun fetchData() {
        // TODO: Start loading here

        val dayOfWeek = Calendar.DAY_OF_WEEK
        
        val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        val hadithList = firestore.collection("xadis")
        hadithList.document("$dayOfWeek")
            .get()
            .addOnSuccessListener {
                // TODO: Stop loading here

                Log.d("DailyHadithFragment >> ", "Data: ${it.toObject(Hadith::class.java)}")
                val hadith = it.toObject(Hadith::class.java)
                binding.apply {
                    tvHadithTitle.text = hadith?.name
                    tvHadithArabic.text = hadith?.arabic
                    tvHadithUzbek.text = hadith?.uzbek
                    tvHadithDescription.text = hadith?.description
                    tvHadithDescHeader.text = "Sharh"
                }

            }
            .addOnFailureListener {
                // TODO: Stop loading here

                it.printStackTrace()
                Toast.makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show()
            }
    }

    private fun setUpToolbar() {
        binding.toolbarFragment.apply {
            // Kerakli Title set qilinadi.
            tvTitle.isSelected = true
            tvTitle.text = "Kunlik hadis"
            // Right ga hohlagan iconkani set qilib yoki invisible, visible qilib, clickni boshqarsa bo`ladi.
            ivRight.setOnClickListener {

            }
        }
    }

    override fun getToolbar(): Toolbar = binding.toolbarFragment.toolbarLayout
}