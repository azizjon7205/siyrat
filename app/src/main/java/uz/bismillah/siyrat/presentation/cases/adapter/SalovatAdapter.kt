package uz.bismillah.siyrat.presentation.cases.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.bismillah.siyrat.data.resourse.local.room.Salovat
import uz.bismillah.siyrat.databinding.ItemSalovatBinding

class SalovatAdapter: ListAdapter<Salovat, SalovatAdapter.SalovatVH>(ITEM_DIFF) {

    var onClick: ((Salovat,id:Int) -> Unit)? = null

    companion object{
        val ITEM_DIFF = object: DiffUtil.ItemCallback<Salovat>() {
            override fun areItemsTheSame(oldItem: Salovat, newItem: Salovat): Boolean {
                return oldItem.allCount == newItem.allCount
            }

            override fun areContentsTheSame(oldItem: Salovat, newItem: Salovat): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class SalovatVH(var binding: ItemSalovatBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(salovat: Salovat){
            binding.apply {
                tvNumberSalovat.text = (adapterPosition+1).toString()
                tvSalovatArabic.text = salovat.arabicText
                tvSalovatUzbek.text = salovat.uzbekText
                tvSalovatTodayCount.text = salovat.todayCount.toString()
                tvSalovatAllCount.text = salovat.allCount.toString()
                llConatiner.setOnClickListener {
                    onClick?.invoke(salovat,adapterPosition)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SalovatVH {
        return SalovatVH(ItemSalovatBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SalovatVH, position: Int) {
        holder.bind(getItem(position))
    }

}