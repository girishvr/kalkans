package com.bitjini.kalkans;


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
                EnglishTab tab1=new EnglishTab();
                return tab1;
            case 1:
                HindiTab tab2=new HindiTab();
                return tab2;

            default: return null;
        }

    }

    @Override
    public int getCount() {
        return nNoOfTabs;
    }
}

