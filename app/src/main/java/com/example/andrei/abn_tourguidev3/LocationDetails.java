package com.example.andrei.abn_tourguidev3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Andrei on 3/2/2018.
 */

public class LocationDetails extends AppCompatActivity {

    public Location mLocation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_details);

        updateView();
    }

    /**
     * Method which will update all the details on the location_details.xml view.
     */
    private void updateView() {
        Intent intent = getIntent();
        String code = intent.getStringExtra("object_code");

        //get the right song from all list by using the intent received
        final ArrayList<Location> mList = MainActivity.allLocations;
        mLocation = null;

        //find the right location
        int lg = mList.size();
        for (int i = 0; i < lg; i++) {
            if (String.valueOf(mList.get(i)).compareTo(code) == 0) {
                mLocation = mList.get(i);
                break;
            }
        }

        //update head wrapper color
        LinearLayout mHeadColor = findViewById(R.id.details_head_wrapper);
        mHeadColor.setBackgroundColor(pickColor(mLocation.getCategory()));

        //update head icon
        ImageView mHeadIcon = findViewById(R.id.details_head_icon);
        mHeadIcon.setImageResource(pickImage(mLocation.getCategory()));

        //update art details
        ImageView mArt = findViewById(R.id.details_art);
        if (mLocation.getArt() == 0) {
            mArt.setVisibility(View.GONE);
        } else {
            mArt.setVisibility(View.VISIBLE);
            mArt.setImageResource(mLocation.getArt());
        }

        //update title
        TextView mTitle = findViewById(R.id.details_title);
        mTitle.setText(mLocation.getName());

        //update description
        TextView mDescription = findViewById(R.id.details_description);
        mDescription.setText(mLocation.getDetails());

        //add intent to open map
        TextView mCoordinates = findViewById(R.id.details_location);
        if (mLocation.getLocation().compareTo("0") == 0) {
            mCoordinates.setText("Location unavailable");
        } else {
            mCoordinates.setText("Location");
            mCoordinates.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //from https://developers.google.com/maps/documentation/urls/android-intents

                    // Create a Uri from an intent string. Use the result to create an Intent.
                    Uri gmmIntentUri = Uri.parse("geo:" + mLocation.getLocation());
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    startActivity(mapIntent);
                }
            });
        }

        //update phone
        TextView mPhone = findViewById(R.id.details_phone);
        if (mLocation.getPhone().compareTo("0") == 0) {
            mPhone.setText("unavailable");
        } else {
            mPhone.setText(mLocation.getPhone());

            //add intent to phone click to open the telephone
            mPhone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + mLocation.getPhone()));
                    startActivity(intent);
                }
            });
        }

        //update website
        TextView mWebsite = findViewById(R.id.details_website);
        if (mLocation.getWebsite() != null) {
            mWebsite.setText(mLocation.getWebsite());

            mWebsite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(mLocation.getWebsite()));
                    startActivity(intent);
                }
            });
        } else {
            mWebsite.setText("unavailable");
        }
    }

    /**
     * Returns a color depending on the category.
     *
     * @param category the given category
     * @return a color int value
     */
    private int pickColor(int category) {
        if (category == 0) return getResources().getColor(R.color.cath1);
        if (category == 1) return getResources().getColor(R.color.cath2);
        if (category == 2) return getResources().getColor(R.color.cath3);
        if (category == 3) return getResources().getColor(R.color.cath4);
        return 0;
    }

    private int pickImage(int category) {
        if (category == 0) return R.drawable.ic_whatshot_black_24dp;
        if (category == 1) return R.drawable.ic_local_florist_black_24dp;
        if (category == 2) return R.drawable.ic_local_dining_black_24dp;
        if (category == 3) return R.drawable.ic_local_bar_black_24dp;
        return 0;
    }
}
