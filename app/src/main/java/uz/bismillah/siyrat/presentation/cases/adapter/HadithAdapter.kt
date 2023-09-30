package uz.bismillah.siyrat.presentation.cases.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.bismillah.siyrat.data.resourse.network.response.Case
import uz.bismillah.siyrat.data.resourse.network.response.Hadith
import uz.bismillah.siyrat.databinding.ItemCaseHadithBinding
import uz.bismillah.siyrat.databinding.ItemCaseSiyratBinding

class HadithAdapter: ListAdapter<Hadith, HadithAdapter.HadithVH>(ITEM_DIFF) {

    var onClick: ((Hadith) -> Unit)? = null

    companion object{
        val ITEM_DIFF = object: DiffUtil.ItemCallback<Hadith>() {
            override fun areItemsTheSame(oldItem: Hadith, newItem: Hadith): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Hadith, newItem: Hadith): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class HadithVH(var binding: ItemCaseHadithBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(hadith: Hadith){
            binding.apply {
                tvHadithArabic.text = hadith.arabic
                tvHadithUzbek.text = hadith.uzbek
                tvInfo.text = "${adapterPosition+1}-Hadis"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadithVH {
        return HadithVH(ItemCaseHadithBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HadithVH, position: Int) {
        holder.bind(getItem(position))
    }

}