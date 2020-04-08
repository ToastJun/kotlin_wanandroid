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
import com.toast.wanandroid.databinding.ItemRvGardenBinding
import com.toast.wanandroid.sunflower.data.PlantAndGardenPlantings
import com.toast.wanandroid.sunflower.viewmodels.PlantAndGardenPlantingsViewModel

/**
 * @author toast
 * @date 2020/4/7 15:11
 * @description
 */
class GardenPlantingAdapter:
    ListAdapter<PlantAndGardenPlantings, GardenPlantingAdapter.GardenPlantingHolder>(
        GardenPlantDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GardenPlantingHolder {
        return GardenPlantingHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_rv_garden, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: GardenPlantingHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class GardenPlantingHolder(private val binding: ItemRvGardenBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                binding.viewModel?.plantId?.let { plantId ->
                    navigateToPlant(plantId, view)
                }
            }
        }

        private fun navigateToPlant(plantId: String, view: View) {
            Toast.makeText(binding.root.context.applicationContext, "plantId=$plantId", Toast.LENGTH_SHORT)
                .show()
        }

        fun bind(plantings: PlantAndGardenPlantings) {
            with(binding) {
                viewModel = PlantAndGardenPlantingsViewModel(plantings)
                executePendingBindings()
            }
        }
    }
}

private class GardenPlantDiffCallback: DiffUtil.ItemCallback<PlantAndGardenPlantings>() {
    override fun areItemsTheSame(
        oldItem: PlantAndGardenPlantings,
        newItem: PlantAndGardenPlantings
    ): Boolean {
        return oldItem.plant.plantId == newItem.plant.plantId
    }

    override fun areContentsTheSame(
        oldItem: PlantAndGardenPlantings,
        newItem: PlantAndGardenPlantings
    ): Boolean {
        return oldItem.plant == newItem.plant
    }

}