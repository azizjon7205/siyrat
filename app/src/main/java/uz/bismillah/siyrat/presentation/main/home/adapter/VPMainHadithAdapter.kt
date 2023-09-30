package uz.bismillah.siyrat.presentation.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.bismillah.siyrat.databinding.ItemViewPagerBinding
import uz.bismillah.siyrat.presentation.main.home.model.MainHadith

class VPMainHadithAdapter : ListAdapter<MainHadith, VPMainHadithAdapter.VH>(ITEM_DIFF) {

    private var moreBtn: ((position: MainHadith) -> Unit)? = null

    fun setMoreBtnListener(f: (position: MainHadith) -> Unit) {
        moreBtn = f
    }

    inner class VH(private val binding: ItemViewPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: MainHadith) {
            binding.apply {
                tvTitle.text = data.name
                tvInfo.text = data.uzbek
                tvMore.setOnClickListener {
                    moreBtn?.invoke(data)
                }
            }
        }
    }

    companion object {
        private val ITEM_DIFF = object : DiffUtil.ItemCallback<MainHadith>() {
            override fun areItemsTheSame(
                oldItem: MainHadith, newItem: MainHadith,
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: MainHadith, newItem: MainHadith,
            ): Boolean {
                return oldItem == newItem
                        && oldItem.name == newItem.name
                        && oldItem.uzbek == newItem.text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH = VH(
        ItemViewPagerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: VH, position: Int) =
        holder.bindData(currentList[position])

    override fun getItemCount(): Int = currentList.size
}