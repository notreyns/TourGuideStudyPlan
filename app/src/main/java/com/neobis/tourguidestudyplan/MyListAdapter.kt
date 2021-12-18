package com.neobis.tourguidestudyplan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide

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

        val itemView = LayoutInflater.from(context).inflate(R.layout.place_item_card, parent, false)
        val nameTextView = itemView.findViewById(R.id.name_tv) as TextView
        val shortDescrTextView = itemView.findViewById(R.id.description_tv) as TextView
        val longDescrTextView = itemView.findViewById(R.id.long_description) as TextView
        val addressTextView = itemView.findViewById(R.id.address_tv) as TextView
        val addressTextView2 = itemView.findViewById(R.id.invisible_address_tv) as TextView
        val scheduleTextView = itemView.findViewById(R.id.schedule_tv) as TextView
        val phoneTextView = itemView.findViewById(R.id.phone_tv) as TextView
        val placeImageView = itemView.findViewById(R.id.image_img) as ImageView
        val titleTextView = itemView.findViewById(R.id.title_tv) as TextView

        val visisibleLayout = itemView.findViewById(R.id.visible_cl) as ConstraintLayout
        val invisisibleLayout = itemView.findViewById(R.id.invisible_cl) as ConstraintLayout
        val descrLayout = itemView.findViewById(R.id.description_ll) as LinearLayout

        val expandImg = itemView.findViewById(R.id.expand_img) as ImageView
        val closeImg = itemView.findViewById(R.id.close_img) as ImageView

        val placeItem = getItem(position) as Place

        nameTextView.text = placeItem.name
        titleTextView.text = placeItem.name

        shortDescrTextView.text = placeItem.shortDescription
        longDescrTextView.text = placeItem.schedule
        addressTextView.text = placeItem.address
        addressTextView2.text = placeItem.address
        scheduleTextView.text = placeItem.schedule
        phoneTextView.text = placeItem.phone
        Glide.with(context).load(placeItem.imageResource).into(placeImageView)


        expandImg.setOnClickListener {
            invisisibleLayout.visibility = View.VISIBLE
            expandImg.visibility = View.GONE
            descrLayout.visibility = View.GONE
            titleTextView.visibility = View.VISIBLE
        }
        closeImg.setOnClickListener {
            invisisibleLayout.visibility = View.GONE
            expandImg.visibility = View.VISIBLE
            descrLayout.visibility = View.VISIBLE
            titleTextView.visibility = View.GONE
        }

        phoneTextView.setOnClickListener{
            onPhoneClickListener?.invoke(placeItem.phone)
        }

        addressTextView2.setOnClickListener{
            onLocationClickListener?.invoke(placeItem.address)
        }


        return itemView
    }

}
