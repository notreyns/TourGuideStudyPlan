package com.neobis.tourguidestudyplan.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.neobis.tourguidestudyplan.R
import com.neobis.tourguidestudyplan.databinding.PlaceItemCardBinding
import com.neobis.tourguidestudyplan.model.Place

class MyListAdapter(
    private val context: Context,
    private val listItems: MutableList<Place>
) : BaseAdapter() {

    var onLocationClickListener: ((String) -> Unit)? = null
    var onPhoneClickListener: ((String) -> Unit)? = null

    override fun getCount(): Int {
        return listItems.size
    }

    override fun getItem(position: Int): Any {
        return listItems[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val holder: PlaceViewHolder

        if (convertView == null) {
            val itemBinding = DataBindingUtil.inflate<PlaceItemCardBinding>(
                LayoutInflater.from(parent.context),
                R.layout.place_item_card,
                parent,
                false
            )
            holder = PlaceViewHolder(itemBinding)
            holder.view = itemBinding.root
        } else {
            holder = convertView.tag as PlaceViewHolder

        }
        val placeItem = listItems.get(position)
        with(holder.binding) {
            Glide.with(context).load(placeItem.imageResource).into(imageImg)
            nameTv.text = placeItem.name
            titleTv.text = placeItem.name
            descriptionTv.text = placeItem.shortDescription
            longDescription.text = placeItem.schedule
            addressTv.text = placeItem.address
            invisibleAddressTv.text = placeItem.address
            scheduleTv.text = placeItem.schedule
            phoneTv.text = placeItem.phone
            expandImg.setOnClickListener {
                invisibleCl.visibility = View.VISIBLE
                expandImg.visibility = View.GONE
                descriptionLl.visibility = View.GONE
                titleTv.visibility = View.VISIBLE
            }
            closeImg.setOnClickListener {
                invisibleCl.visibility = View.GONE
                expandImg.visibility = View.VISIBLE
                descriptionLl.visibility = View.VISIBLE
                titleTv.visibility = View.GONE
            }

            phoneTv.setOnClickListener {
                onPhoneClickListener?.invoke(placeItem.phone)
            }

            invisibleAddressTv.setOnClickListener {
                onLocationClickListener?.invoke(placeItem.address)
            }
        }

        return holder.view
    }
}


