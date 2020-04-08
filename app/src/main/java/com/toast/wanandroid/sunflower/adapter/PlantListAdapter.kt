package com.toast.wanandroid.sunflower.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.toast.wanandroid.R
import com.toast.wanandroid.databinding.ItemRvPlantBinding
import com.toast.wanandroid.sunflower.data.Plant

/**
 * @author toast
 * @date 2020/4/8 15:05
 * @description
 */
class PlantListAdapter(
    plantDiffCallback: PlantDiffCallback = PlantDiffCallback()
) : ListAdapter<Plant, PlantListAdapter.ViewHolder>(plantDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_rv_plant,
            parent, false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ViewHolder(private val binding: ItemRvPlantBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                Toast.makeText(binding.root.context, "点击", Toast.LENGTH_SHORT).show()
            }
        }

        // 绑定数据到View
        fun bind(item: Plant) {
            with(binding) {
                plant = item
                executePendingBindings()
            }
        }
    }
}

class PlantDiffCallback: DiffUtil.ItemCallback<Plant>() {
    override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
        return oldItem.plantId == newItem.plantId
    }

    override fun areContentsTheSame(oldItem: Plant, newItem: Plant) = oldItem == newItem

}