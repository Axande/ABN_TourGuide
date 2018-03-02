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
        allLocations.add(new Location("Vapiano",
                "Vapiano is a European restaurant franchise company headquartered in Bonn." +
                        " The chain's restaurants offer Italian food according to the fast-casual principle." +
                        " In April 2017, Vapiano totaled 180 locations in 31 countries, including Australia, " +
                        "China, Saudi Arabia and the United States. For many years, the company was among the " +
                        "fastest-growing players in the industry.",
                "51.4379756,5.477862,17z?q=vapiano",
                "040 760 2070", 2, R.drawable.vapiano, "https://nl.vapiano.com/nl/home/"));

        allLocations.add(new Location("Café 't Lempke", "Everyone in Eindhoven knows 't Lempke. " +
                "From what? From the hours of dancing for, next to and especially at the bar. " +
                "Every Thursday, Friday and Saturday, 't Lempke is full of nightlife, what makes 't Lempke one of the " +
                "most crowded nightlife locations in Eindhoven. But people also know 't Lempke as the permanent home " +
                "of many student associations . ",
                "51.4367399,5.478519,17zq=Café 't Lempke", "06 52655204", 3, R.drawable.lempke, "http://lempke.nl/"));

        allLocations.add(new Location("Bar Bistro Calypso", "Bar Bistro Calypso openend on January first this year." +
                " It is located on Stratumseind, right in the middle of the street.",
                "51.4359714,5.4807166,17zq=Bar Bistro Calypso", "040 368 0691", 3, R.drawable.calypso, "http://bistrocalypso.nl"));

        allLocations.add(new Location("Evoluon", "The Evoluon is a conference centre and former science museum erected" +
                " by the electronics and electrical company Philips at Eindhoven in the Netherlands in 1966." +
                " Since its construction, it has become a landmark and a symbol for the city.",
                "51.443633,5.4410833,17zq=Evoluon", "0", 1, R.drawable.evoluon));

        for (int i = 1; i <= 1000; i++) {
            if (randomBool()) //to add dummy image or not
                allLocations.add(new Location("Dummy data " + i, "Lorem Ipsum is simply dummy text of the printing and " +
                        "typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when " +
                        "an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived " +
                        "not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                        "51.4455368,5.3814704,12zq=Eindhoven", "0", getRandomInt(5)));
            else
                allLocations.add(new Location("Dummy data " + i, "Lorem Ipsum is simply dummy text of the printing and " +
                        "typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when " +
                        "an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived " +
                        "not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                        "0", "0", getRandomInt(5), R.drawable.dummy_img));
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
