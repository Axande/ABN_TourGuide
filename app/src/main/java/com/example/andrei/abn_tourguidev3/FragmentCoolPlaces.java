package com.example.andrei.abn_tourguidev3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class FragmentCoolPlaces extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cool_places, container, false);

        //create a Location adapter for Cool places
        LocationAdapter mAdapter = new LocationAdapter(container.getContext(), MainActivity.filter(0));

        //find the list view that needs to be filled
        ListView mListView = view.findViewById(R.id.view_cool_places_list);

        //attach adapter to listview
        mListView.setAdapter(mAdapter);

        //add on item click listener
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //create an intent with the object memory address
                Location item = (Location) parent.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), LocationDetails.class);
                intent.putExtra("object_code", String.valueOf(item));
                startActivity(intent);
            }
        });

        return view;
    }
}
