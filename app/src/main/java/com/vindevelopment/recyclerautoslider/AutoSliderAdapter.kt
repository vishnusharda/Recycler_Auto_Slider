package com.vindevelopment.recyclerautoslider

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vindevelopment.recyclerautoslider.AutoSliderAdapter.AutoSliderViewHolder

class AutoSliderAdapter(var context: Context, var autoSliderModelList: List<AutoSliderModel>) :
    RecyclerView.Adapter<AutoSliderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutoSliderViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.auto_slider_item, parent, false)
        return AutoSliderViewHolder(view)
    }

    override fun onBindViewHolder(holder: AutoSliderViewHolder, position: Int) {
        val autoSliderModel = autoSliderModelList[position]
        Glide.with(context)
            .load(autoSliderModel.autoSlider_image)
            .into(holder.AutoSlider_image)
    }

    override fun getItemCount(): Int {
        return autoSliderModelList.size
    }

    inner class AutoSliderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var AutoSlider_image: ImageView

        init {
            AutoSlider_image = itemView.findViewById(R.id.AutoSlider_image)
        }
    }
}
