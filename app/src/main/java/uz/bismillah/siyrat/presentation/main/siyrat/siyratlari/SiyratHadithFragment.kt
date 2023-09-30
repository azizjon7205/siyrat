package uz.bismillah.siyrat.presentation.main.siyrat.siyratlari

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
import uz.bismillah.siyrat.databinding.FragmentSiyratHadithBinding
import uz.bismillah.siyrat.presentation.cases.adapter.HadithAdapter
import uz.bismillah.siyrat.presentation.main.BaseMainFragment
import uz.bismillah.siyrat.presentation.main.siyrat.siyratlari.model.SiyratData

class SiyratHadithFragment :
    BaseMainFragment<FragmentSiyratHadithBinding>(FragmentSiyratHadithBinding::inflate) {

    override fun onViewCreate() {
        binding.toolbarLayoutHadith.tvTitle.text = resources.getString(R.string.all_siyratlar)
        fetchData()

    }


    private fun fetchData() {
        val adapter = HadithAdapter()
        val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        val case = firestore.collection("siyrat-hadith")
        case.get()
            .addOnSuccessListener {
                //TODO: Stop loading here

                Log.d("HadithListForCasesFragment >> ", "Data: ${it.toObjects(Hadith::class.java)}")
                val hadithList = it.toObjects(Hadith::class.java)
                adapter.submitList(hadithList)
                binding.rvHadith.adapter = adapter
            }
            .addOnFailureListener {
                // TODO: Stop loading here

                it.printStackTrace()
                Toast.makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show()
            }
    }

    override fun getToolbar(): Toolbar = binding.toolbarLayoutHadith.toolbarLayout
}