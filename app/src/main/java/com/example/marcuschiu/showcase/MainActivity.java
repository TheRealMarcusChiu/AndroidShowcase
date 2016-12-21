package com.example.marcuschiu.showcase;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.marcuschiu.showcase.background.HttpGetActivity;
import com.example.marcuschiu.showcase.ui.FullscreenActivity;
import com.example.marcuschiu.showcase.ui.LoginActivity;
import com.example.marcuschiu.showcase.ui.NavigationDrawerActivity;
import com.example.marcuschiu.showcase.ui.ScrollingActivity;
import com.example.marcuschiu.showcase.ui.SettingsActivity;
import com.example.marcuschiu.showcase.ui.SwipeRefreshActivity;
import com.example.marcuschiu.showcase.ui.combo.ComboMainActivity;
import com.example.marcuschiu.showcase.ui.master.detail.flow.MasterDetailFlowItemListActivity;
import com.example.marcuschiu.showcase.ui.pager.view.main.ViewPagerMainActivity;

public class MainActivity  extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * UI Fragment
     */
    public static class UIFragment extends Fragment {
        public UIFragment() {
        }

        public static UIFragment newInstance() {
            UIFragment fragment = new UIFragment();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.b_ui_fragment, container, false);
            return rootView;
        }
    }

    /**
     * Background Fragment
     */
    public static class BackgroundFragment extends Fragment {
        public BackgroundFragment() {
        }

        public static BackgroundFragment newInstance() {
            BackgroundFragment fragment = new BackgroundFragment();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.b_background_fragment, container, false);
            return rootView;
        }
    }

    /**
     * Background Fragment
     */
    public static class UndefinedFragment extends Fragment {
        public UndefinedFragment() {
        }

        public static UndefinedFragment newInstance() {
            UndefinedFragment fragment = new UndefinedFragment();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.b_undefined_fragment, container, false);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: return UIFragment.newInstance();
                case 1: return BackgroundFragment.newInstance();
            }

            return UndefinedFragment.newInstance();
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "UI";
                case 1:
                    return "Background";
            }
            return "Undefined";
        }
    }

    // UI Part //
    public void goToComboActivity(View view) {
        startActivity(new Intent(this, ComboMainActivity.class));
    }
    public void goToNavigationDrawerActivity(View view) {
        startActivity(new Intent(this, NavigationDrawerActivity.class));
    }
    public void goToScrollingActivity(View view) {
        startActivity(new Intent(this, ScrollingActivity.class));
    }
    public void goToViewPagerMainActivity(View view) {
        startActivity(new Intent(this, ViewPagerMainActivity.class));
    }
    public void goToLoginActivity(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
    public void goToMasterDetailFlowItemListActivity(View view) {
        startActivity(new Intent(this, MasterDetailFlowItemListActivity.class));
    }
    public void goToSettingsActivity(View view) {
        startActivity(new Intent(this, SettingsActivity.class));
    }
    public void goToFullscreenActivity(View view) {
        startActivity(new Intent(this, FullscreenActivity.class));
    }
    public void goToSwipeRefreshActivity(View view) {
        startActivity(new Intent(this, SwipeRefreshActivity.class));
    }

    // Background Part //
    public void goToHttpGetActivity(View view) {
        startActivity(new Intent(this, HttpGetActivity.class));
    }
}
