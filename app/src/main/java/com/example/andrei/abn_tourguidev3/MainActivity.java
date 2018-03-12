package com.example.andrei.abn_tourguidev3;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Location> allLocations = new ArrayList<>();

    /**
     * Public class to filter the locations according to the category.
     *
     * @param category the category
     * @return a filtered ArrayList
     */
    public static ArrayList<Location> filter(int category) {
        ArrayList<Location> temp = new ArrayList<>();
        int size = allLocations.size();

        for (int i = 0; i < size; i++) {
            if (allLocations.get(i).getCategory() == category)
                temp.add(allLocations.get(i));
        }
        return temp;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addLocations();

        ViewPager mViewPager = findViewById(R.id.view_pager);

        FragmentAdapter mAdapter = new FragmentAdapter(this, getSupportFragmentManager());

        mViewPager.setAdapter(mAdapter);

        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabs);

        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.getTabAt(0).setIcon(R.drawable.ic_public_black_24dp);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_whatshot_black_24dp);
        mTabLayout.getTabAt(2).setIcon(R.drawable.ic_local_florist_black_24dp);
        mTabLayout.getTabAt(3).setIcon(R.drawable.ic_local_dining_black_24dp);
        mTabLayout.getTabAt(4).setIcon(R.drawable.ic_local_bar_black_24dp);

    }

    private void addLocations() {
        allLocations.add(new Location(getString(R.string.vapiano_title),
                getString(R.string.vapiano_description),
                getString(R.string.vapiano_location),
                getString(R.string.vapiano_phone),
                2,
                R.drawable.vapiano,
                getString(R.string.vapiano_website)));

        allLocations.add(new Location(getString(R.string.lempke_title),
                getString(R.string.lempke_description),
                getString(R.string.lempke_location),
                getString(R.string.lempke_phone),
                3,
                R.drawable.lempke,
                getString(R.string.lempke_website)));

        allLocations.add(new Location(getString(R.string.calypso_title),
                getString(R.string.calypso_description),
                getString(R.string.calypso_location),
                getString(R.string.calypso_phone),
                3,
                R.drawable.calypso,
                getString(R.string.calypso_website)));

        allLocations.add(new Location(getString(R.string.evoluon_title),
                getString(R.string.evoluon_description),
                getString(R.string.evoluon_location),
                getString(R.string.evoluon_phone),
                1,
                R.drawable.evoluon));


        allLocations.add(new Location(getString(R.string.philips_title),
                getString(R.string.philips_description),
                getString(R.string.philips_location),
                getString(R.string.philips_phone),
                0,
                R.drawable.philips));

        allLocations.add(new Location(getString(R.string.gp_title),
                getString(R.string.gp_description),
                getString(R.string.gp_location),
                getString(R.string.gp_phone),
                1,
                R.drawable.gp));

        allLocations.add(new Location(getString(R.string.effenaar_title),
                getString(R.string.effenaar_description),
                getString(R.string.effenaar_location),
                getString(R.string.effenaar_phone),
                3,
                R.drawable.effenar));

        allLocations.add(new Location(getString(R.string.abbemuseum_title),
                getString(R.string.abbemuseum_description),
                getString(R.string.abbemuseum_location),
                getString(R.string.abbemuseum_phone),
                0,
                R.drawable.abbemuseum,
                getString(R.string.abbemuseum_website)));


        allLocations.add(new Location(getString(R.string.psv_title),
                getString(R.string.psv_description),
                getString(R.string.psv_location),
                getString(R.string.psv_phone),
                0,
                R.drawable.psv,
                getString(R.string.psv_website)));

        allLocations.add(new Location(getString(R.string.daf_title),
                        getString(R.string.daf_description),
                        getString(R.string.daf_location),
                        getString(R.string.daf_phone),
                        0,
                        R.drawable.daf,
                    getString(R.string.daf_website)));

        //Code for generating dummy data sets
        for (int i = 1; i <= 1000; i++) {
            if (randomBool()) //to add dummy image or not
                allLocations.add(new Location(
                        getString(R.string.dummy_title) + i,
                        getString(R.string.dummy_description),
                        getString(R.string.dummy_location),
                        getString(R.string.dummy_phone),
                        getRandomInt(5)));
            else
                allLocations.add(new Location(
                        getString(R.string.dummy_title) + i,
                        getString(R.string.dummy_description),
                        getString(R.string.dummy_empty_location) ,
                        getString(R.string.dummy_phone),
                        getRandomInt(5),
                        R.drawable.dummy_img));
        }
    }

    private boolean randomBool() {
        Double aux = (Math.random() * 10);
        int result = aux.intValue() % 2;
        return result == 0;
    }

    /**
     * Generate an int of maximum maxVal value.
     *
     * @param maxVal is the maximum generated value
     * @return a random integer
     */
    private int getRandomInt(int maxVal) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, maxVal);
        return randomNum;
    }

}
