package com.neobis.tourguidestudyplan

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView


class CinemaFragment : Fragment() {
    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        listView = view.findViewById<ListView>(R.id.place_listview)

        val listItems = mutableListOf<Place>(
            Place("Broadway","Кинотеатр", "Asia Mall 3 этаж", "Открыто до 23:00", R.drawable.cinema_1,"+996 778 651 264"),
            Place("Манас","Кинотеатр", "Проспект Манаса 47А", "Открыто до 22:00", R.drawable.cinema_2,"+996 778 651 264"),
            Place("Ала-Тоо","Кинотеатр", "Проспект Чуй 187", "Открыто до 05:00", R.drawable.cinema_3,"+996 778 651 264"),
            Place("ЦУМ Cinema","Кинотеатр", "Ул. Шопокова", "Открыто до 22:00", R.drawable.cinema_4,"+996 778 651 264"),
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