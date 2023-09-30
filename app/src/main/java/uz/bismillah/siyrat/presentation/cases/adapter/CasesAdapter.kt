package uz.bismillah.siyrat.presentation.cases.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.bismillah.siyrat.data.resourse.network.response.Case
import uz.bismillah.siyrat.databinding.ItemCaseSiyratBinding

class CasesAdapter: ListAdapter<Case, CasesAdapter.CaseVH>(ITEM_DIFF) {

    var onClick: ((Case) -> Unit)? = null

    companion object{
        val ITEM_DIFF = object: DiffUtil.ItemCallback<Case>() {
            override fun areItemsTheSame(oldItem: Case, newItem: Case): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Case, newItem: Case): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class CaseVH(var binding: ItemCaseSiyratBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(case: Case){
            binding.apply {
                tvTitle.text = case.name
                llContainer.setOnClickListener {
                    onClick?.invoke(case)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CaseVH {
        return CaseVH(ItemCaseSiyratBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CaseVH, position: Int) {
        holder.bind(getItem(position))
    }

}