package com.example.demoapp.adapter

import com.example.demoapp.R
import com.example.demoapp.base.BaseRecyclerViewAdapter
import com.example.demoapp.data.model.network.ColorResponseObject
import com.example.demoapp.databinding.ImageRowBinding

class ColorListAdapter :
    BaseRecyclerViewAdapter<ColorResponseObject, ImageRowBinding>() {
    override fun getLayout() = R.layout.image_row

    override fun onBindViewHolder(
        holder: Companion.BaseViewHolder<ImageRowBinding>,
        position: Int
    ) {
        holder.binding.colorResponseObject = items[position]
    }
}