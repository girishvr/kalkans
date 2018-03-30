//package com.bitjini.kalkans;
//
//
//import android.app.Fragment;
//import android.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;
//
//public class PageAdapter extends FragmentPagerAdapter {
//
//    private int numOfTabs;
//
//  //  PageAdapter(FragmentManager fm, int numOfTabs) {
//        //super(fm);
//        this.numOfTabs = numOfTabs;
//    }
//
//
//
//    @Override
//    public Fragment getItem(int position) {
//        switch (position) {
//            case 0:
//                return new EngFragment();
//            case 1:
//                return new HinFragment();
//
//            default:
//                return null;
//        }
//    }
//
//    @Override
//    public int getCount() {
//        return numOfTabs;
//    }
//}