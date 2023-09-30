package uz.bismillah.siyrat.presentation.cases

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
import uz.bismillah.siyrat.databinding.FragmentHadithListForCasesBinding
import uz.bismillah.siyrat.presentation.cases.adapter.HadithAdapter
import uz.bismillah.siyrat.presentation.cases.adapter.StateAdapter
import uz.bismillah.siyrat.presentation.cases.model.State
import java.util.Calendar


class HadithListForCasesFragment : BaseCasesFragment<FragmentHadithListForCasesBinding>(FragmentHadithListForCasesBinding::inflate) {

    override fun onViewCreate() {
//        setUpToolbar()
        initViews()
    }

    private fun initViews() {
        // TODO: Start loading here

        val path = arguments?.getString("path")
        fetchData(path)

        binding.apply {
            toolbarLayoutHadith.tvTitle.text = path
        }
    }

    private fun fetchData(path: String?) {
        val adapter = StateAdapter()
        val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        val case = firestore.collection("holatlar").document(path ?: "").collection("xadis")
        case.get()
            .addOnSuccessListener {
                //TODO: Stop loading here

                Log.d("HadithListForCasesFragment >> ", "Data: ${it.toObjects(State::class.java)}")
                val hadithList = it.toObjects(State::class.java)
                adapter.submitList(hadithList)
                binding.rvHadith.adapter = adapter
            }
            .addOnFailureListener {
                // TODO: Stop loading here

                it.printStackTrace()
                Toast.makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show()
            }
    }

    private fun setUpToolbar() {
        binding.toolbarLayoutHadith.apply {
            // Kerakli Title set qilinadi.
            tvTitle.isSelected = true
            tvTitle.text = "Kunlik hadis"
            // Right ga hohlagan iconkani set qilib yoki invisible, visible qilib, clickni boshqarsa bo`ladi.
            ivRight.setOnClickListener {

            }
        }
    }

    override fun getToolbar(): Toolbar = binding.toolbarLayoutHadith.toolbarLayout
}