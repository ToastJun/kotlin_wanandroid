package com.toast.wanandroid.sunflower.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.toast.wanandroid.R
import com.toast.wanandroid.databinding.ItemRvPlantBinding
import com.toast.wanandroid.sunflower.HomeViewPagerFragmentDirections
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
                binding.plant?.let { plant ->
                    navigateDetail(it, plant)
                }
            }
        }

        private fun navigateDetail(view: View, plant: Plant) {
            val directions =
                HomeViewPagerFragmentDirections.actionViewPagerFragmentToPlantDetailFragment(plant.plantId)
            // 共享元素
            val extras =
                FragmentNavigatorExtras(binding.plantImage to "transition_detail_image")
            val bundle = Bundle()
            bundle.putString("plantId", plant.plantId)
            view.findNavController().navigate(R.id.action_view_pager_fragment_to_plant_detail_fragment,
                bundle, null, extras)
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