package com.example.hp.slide;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {
    // Declare Tab Variable
    ActionBar.Tab Tab1, Tab2, Tab3;
    Fragment fragmentTab1 = new FragmentTab1();
    Fragment fragmentTab2 = new Fragmenttab2();
    //Fragment fragmentTab3 = new FragmentTab3();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();

        // Hide Actionbar Icon
        actionBar.setDisplayShowHomeEnabled(false);

        // Hide Actionbar Title
        actionBar.setDisplayShowTitleEnabled(false);

        // Create Actionbar Tabs
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Set Tab Icon and Titles
        Tab1 = actionBar.newTab().setIcon(Drawable.createFromPath("tab1"));
        Tab2 = actionBar.newTab().setText("Tab2");
      //  Tab3 = actionBar.newTab().setText("Tab3");

        // Set Tab Listeners
        Tab1.setTabListener(new android.support.v7.app.ActionBar.TabListener(FragmentTab1) {
            @Override
            public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }
        });
        Tab2.setTabListener(new android.support.v7.app.ActionBar.TabListener(fragmentTab2));
       // Tab3.setTabListener(new TabListener(fragmentTab3));

        // Add tabs to actionbar
        actionBar.addTab(Tab1);
        actionBar.addTab(Tab2);
        //actionBar.addTab(Tab3);
    }
}
