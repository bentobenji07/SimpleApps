package com.example.simpleapps.screen;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.widget.TextView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import android.graphics.PorterDuff;

import com.example.simpleapps.R;

public class DashboardActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    ArrayList<Fragment> fragments;
    Toolbar toolbar;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        fragments =new ArrayList<>();

        fragments.add(new HomeFragment());
        fragments.add(new ProfileFragment());


        DashboardFragmentAdapter pagerAdapter = new DashboardFragmentAdapter(getSupportFragmentManager(), getApplicationContext(), fragments);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home_icon);
        tabLayout.getTabAt(1).setIcon(R.drawable.profile_icon);


    }
}
