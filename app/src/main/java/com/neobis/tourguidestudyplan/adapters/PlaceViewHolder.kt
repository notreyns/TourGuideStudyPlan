package com.neobis.tourguidestudyplan.adapters

import android.view.View
import com.neobis.tourguidestudyplan.databinding.PlaceItemCardBinding

class PlaceViewHolder(binding: PlaceItemCardBinding) {
    var view: View
    val binding: PlaceItemCardBinding
    init {
        view = binding.root
        this.binding = binding
    }
}