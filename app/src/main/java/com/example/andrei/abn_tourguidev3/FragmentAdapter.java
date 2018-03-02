package com.example.andrei.abn_tourguidev3;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Andrei on 3/2/2018.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context mContext;

    public FragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FragmentAllLocations();
        } else if (position == 1) {
            return new FragmentCoolPlaces();
        } else if (position == 2) {
            return new FragmentParks();
        } else if (position == 3) {
            return new FragmentRestaurants();
        } else if (position == 4) {
            return new FragmentBars();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }
}
