package uz.bismillah.siyrat.presentation.cases.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.bismillah.siyrat.databinding.ItemCaseHadithBinding
import uz.bismillah.siyrat.presentation.cases.model.State
import uz.bismillah.siyrat.utils.extensions.gone

class StateAdapter: ListAdapter<State, StateAdapter.StateVH>(ITEM_DIFF) {

    var onClick: ((State) -> Unit)? = null

    companion object{
        val ITEM_DIFF = object: DiffUtil.ItemCallback<State>() {
            override fun areItemsTheSame(oldItem: State, newItem: State): Boolean {
                return oldItem.description == newItem.description
            }

            override fun areContentsTheSame(oldItem: State, newItem: State): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class StateVH(var binding: ItemCaseHadithBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(hadith: State){
            binding.apply {
                tvHadithArabic.gone()
                tvHadithUzbek.text = hadith.description
                tvInfo.text = "${adapterPosition+1}-Voqea"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateVH {
        return StateVH(ItemCaseHadithBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: StateVH, position: Int) {
        holder.bind(getItem(position))
    }

}