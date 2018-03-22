package com.example.hp.gapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            // Adding Toolbar to Main screen
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("Tab 1"));
        tabs.addTab(tabs.newTab().setText("Tab 2"));
        tabs.addTab(tabs.newTab().setText("Tab 3"));

        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }
    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new ListContentFragment(), "List");
        adapter.addFragment(new TileContentFragment(), "Tile");
        adapter.addFragment(new CardContentFragment(), "Card");
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
            public static class ViewHolder extends RecyclerView.ViewHolder {
                public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
                    super(inflater.inflate(R.layout.item_tile, parent, false));
                }
            }
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
            public static class ViewHolder extends RecyclerView.ViewHolder {
                public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
                    super(inflater.inflate(R.layout.item_tile, parent, false));
                }
            }
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
            public static class ViewHolder extends RecyclerView.ViewHolder {
                public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
                    super(inflater.inflate(R.layout.item_tile, parent, false));
                }
            }
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
            public static class ViewHolder extends RecyclerView.ViewHolder {
                public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
                    super(inflater.inflate(R.layout.item_tile, parent, false));
                }
            }
            public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
                // Set numbers of List in RecyclerView.
                private static final int LENGTH = 18;

                public ContentAdapter() {
                }

                @Override
                public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                    return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
                }

                @Override
                public void onBindViewHolder(ViewHolder holder, int position) {
                    // no-op
                }

                @Override
                public int getItemCount() {
                    return LENGTH;
                }
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
            public static class ViewHolder extends RecyclerView.ViewHolder {
                public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
                    super(inflater.inflate(R.layout.item_tile, parent, false));
                }
            }
            public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
                // Set numbers of List in RecyclerView.
                private static final int LENGTH = 18;

                public ContentAdapter() {
                }

                @Override
                public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                    return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
                }

                @Override
                public void onBindViewHolder(ViewHolder holder, int position) {
                    // no-op
                }

                @Override
                public int getItemCount() {
                    return LENGTH;
                }
            }
        }
    }
        }


