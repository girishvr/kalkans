package com.example.hp.newtab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Hp on 3/24/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int nNoOfTabs;
    public PagerAdapter(FragmentManager fm ,int NumberOfTabs) {
        super(fm);
        this.nNoOfTabs=NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                Tab1 tab1=new Tab1();
                return tab1;
            case 1:
                Tab2 tab2=new Tab2();
                return tab2;

                default: return null;
        }

    }

    @Override
    public int getCount() {
        return nNoOfTabs;
    }
}
