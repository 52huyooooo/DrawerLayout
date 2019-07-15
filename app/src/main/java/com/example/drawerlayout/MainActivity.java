package com.example.drawerlayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.navigationtest.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private FragAdapter fragAdapter;

    private BottomNavigationBar bottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager_main);
        bottomNavigationBar = findViewById(R.id.nav_main);


        fragmentList = new ArrayList<>();
        fragmentList.add(new FragmentHome());
        fragmentList.add(new FragmentDashboard());
        fragmentList.add(new FragmentNotification());

        fragAdapter =new FragAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(fragAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                bottomNavigationBar.selectTab(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_black_24dp, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.ic_dashboard_black_24dp, "同学圈"))
                .addItem(new BottomNavigationItem(R.drawable.ic_notifications_black_24dp, "通知"))
                .setFirstSelectedPosition(0)
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });



    }
}
