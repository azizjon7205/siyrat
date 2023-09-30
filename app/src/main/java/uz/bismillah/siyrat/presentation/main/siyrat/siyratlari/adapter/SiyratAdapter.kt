package uz.bismillah.siyrat.presentation.main.siyrat.siyratlari.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.bismillah.siyrat.databinding.ItemTitleRightArrowBinding
import uz.bismillah.siyrat.presentation.main.siyrat.siyratlari.model.SiyratData


class SiyratAdapter : ListAdapter<SiyratData, SiyratAdapter.VH>(ITEM_DIFF) {

    private var moreBtn: ((position: SiyratData) -> Unit)? = null

    fun setMoreBtnListener(f: (position: SiyratData) -> Unit) {
        moreBtn = f
    }

    inner class VH(private val binding: ItemTitleRightArrowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: SiyratData) {
            binding.apply {
                tvTitle.text = data.name
            }
        }
    }

    companion object {
        private val ITEM_DIFF = object : DiffUtil.ItemCallback<SiyratData>() {
            override fun areItemsTheSame(
                oldItem: SiyratData, newItem: SiyratData,
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: SiyratData, newItem: SiyratData,
            ): Boolean {
                return oldItem == newItem
                        && oldItem.name == newItem.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH = VH(
        ItemTitleRightArrowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.bindData(currentList[position])

    override fun getItemCount(): Int = currentList.size
}