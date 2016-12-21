package com.example.marcuschiu.showcase.ui.combo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.marcuschiu.showcase.R;

public class ComboMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_activity_combo_main);
    }

    public void goToNavigationDrawerViewPagerActivity(View view) {
        startActivity(new Intent(this, NavigationDrawerViewPagerActivity.class));
    }
}
