package com.example.andrei.abn_tourguidev3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Andrei on 3/2/2018.
 */

public class LocationAdapter extends ArrayAdapter<Location> {

    public LocationAdapter(@NonNull Context context, ArrayList<Location> locations) {
        //2nd field is used when populating a single TextView
        super(context, 0, locations);
    }

    /**
     * @param position    position of this view in the list of data
     * @param convertView recycled view that needs to be repopulated
     * @param parent      list item will be added to this parent as children.
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Location mLocation = getItem(position);

        View listItem = convertView;
        if (convertView == null) {
            //inflate the list item layout
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //update art details
        ImageView mArt = listItem.findViewById(R.id.item_art);
        if (mLocation.getArt() == -1) {
            mArt.setVisibility(View.GONE);
        } else {
            mArt.setVisibility(View.VISIBLE);
            mArt.setImageResource(mLocation.getArt());
        }

        //update title
        TextView mTitle = listItem.findViewById(R.id.item_title);
        mTitle.setText(mLocation.getName());

        //update description
        TextView mDescription = listItem.findViewById(R.id.item_description);
        if (mLocation.getArt() == -1)
            mDescription.setText(transform(50, mLocation.getDetails()));
        else
            mDescription.setText(transform(30, mLocation.getDetails()));

        //update color
        LinearLayout mLayout = listItem.findViewById(R.id.item_wrapper);
        mLayout.setBackgroundColor(pickColor(mLocation.getCategory()));

        //return the created object
        return listItem;
    }

    /**
     * Returns a color depending on the category.
     *
     * @param category the given category
     * @return a color int value
     */
    private int pickColor(int category) {
        if (category == 0) return getContext().getResources().getColor(R.color.cath1);
        if (category == 1) return getContext().getResources().getColor(R.color.cath2);
        if (category == 2) return getContext().getResources().getColor(R.color.cath3);
        if (category == 3) return getContext().getResources().getColor(R.color.cath4);
        return 0;
    }

    /**
     * Return at most k characters from the string s.
     *
     * @param k the maximum number of characters to be returned(k or s.length+3)
     * @param s the string to be analyzed
     * @return a new string according to the description
     */
    private String transform(int k, String s) {
        String aux;

        if (s.length() + 3 <= k)
            aux = s;
        else
            aux = s.substring(0, k - 3);
        aux += "...";
        return aux;
    }
}
