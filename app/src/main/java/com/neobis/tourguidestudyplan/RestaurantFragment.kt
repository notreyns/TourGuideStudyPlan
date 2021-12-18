package com.neobis.tourguidestudyplan

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView


class RestaurantFragment : Fragment() {
    private lateinit var listView: ListView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        listView = view.findViewById<ListView>(R.id.place_listview)

        val listItems = mutableListOf<Place>(
            Place("Cyclone","Ресторан", "Проспект Чуй 136", "Открыто до 23:00", R.drawable.resto_1,"+996 778 651 264"),
            Place("Anar","Ресто-чайхана", "Ул. Льва Толстого, 102/4", "Открыто до 22:00", R.drawable.resto_2,"+996 778 651 264"),
            Place("Бай Казан","Ресто-чайхана", "Ул. К. Баялинова 131", "Открыто до 05:00", R.drawable.resto_3,"+996 778 651 264"),
            Place("BARHAT","Ресто-чайхана", "Ул. Исы Ахунбаева 17А", "Открыто до 22:00", R.drawable.resto_4,"+996 778 651 264"),
        )

        val adapter = MyListAdapter(requireContext(), listItems)
        listView.adapter = adapter

        adapter.onPhoneClickListener = {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $it"));
            startActivity(intent);
        }

        adapter.onLocationClickListener = {
            val gmmIntentUri =
                Uri.parse("geo:0,0?q=Bishkek, $it")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        return view
    }

}