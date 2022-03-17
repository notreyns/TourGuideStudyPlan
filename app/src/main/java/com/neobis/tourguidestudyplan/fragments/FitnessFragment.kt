package com.neobis.tourguidestudyplan.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.neobis.tourguidestudyplan.adapters.MyListAdapter
import com.neobis.tourguidestudyplan.model.Place
import com.neobis.tourguidestudyplan.R


class FitnessFragment : Fragment() {

    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        listView = view.findViewById<ListView>(R.id.place_listview)

        val listItems = mutableListOf<Place>(
            Place("JFC Gym","Спортивный клуб", "Ул. Кара-Кульская 1/4", "Открыто до 23:00", R.drawable.fitness_1,"+996 778 651 264"),
            Place("Beauty Dance Studio","Студия фитнеса и танцев", "ул. Н. Исанова, 41/1", "Открыто до 22:00", R.drawable.fitness_2,"+996 778 651 264"),
            Place("UMAY Dance Fit","Студия фитнеса и танцев", "Проспект Манаса 135", "Открыто до 05:00", R.drawable.fitness_3,"+996 778 651 264"),
            Place("Dasmia","Этно комплекс", "Ул. Максима Горького 23", "Открыто до 22:00", R.drawable.fitness_4,"+996 778 651 264"),
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


