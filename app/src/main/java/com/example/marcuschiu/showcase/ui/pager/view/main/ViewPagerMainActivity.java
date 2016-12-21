package com.example.marcuschiu.showcase.ui.pager.view.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.marcuschiu.showcase.R;

public class ViewPagerMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_view_pager_main_activity);
    }

    public void goToViewPagerActivity(View view) {
        startActivity(new Intent(this, ViewPagerActivity.class));
    }

    public void goToViewPagerWithActionBarTabsActivity(View view) {
        startActivity(new Intent(this, ViewPagerWithActionBarTabsActivity.class));
    }

    public void goToViewPagerWithActionBarSpinnerActivity(View view) {
        startActivity(new Intent(this, ViewPagerWithActionBarSpinnerActivity.class));
    }
}
