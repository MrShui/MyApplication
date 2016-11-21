package com.example.viewpagerdemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        List<View> views = new ArrayList<>();
        final View view1 = new View(this);
        view1.setBackgroundResource(android.R.color.holo_green_dark);
        final View view2 = new View(this);
        view2.setBackgroundResource(android.R.color.holo_blue_dark);
        view2.setScaleX(0.8f);
        view2.setScaleY(0.8f);
        view2.setAlpha(0.8f);
        final View view3 = new View(this);
        view3.setBackgroundResource(android.R.color.holo_purple);
        view3.setScaleX(0.8f);
        view3.setScaleY(0.8f);
        view3.setAlpha(0.8f);
        views.add(view1);
        views.add(view2);
        views.add(view3);
        viewPager.setOffscreenPageLimit(views.size());
        viewPager.setAdapter(new ViewPagerAdapter(views));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 0) {
                    view1.setScaleX(1 - 0.2f * positionOffset);
                    view1.setScaleY(1 - 0.2f * positionOffset);
                    view1.setAlpha(1 - 0.2f * positionOffset);
                    view2.setScaleX(0.8f + 0.2f * positionOffset);
                    view2.setScaleY(0.8f + 0.2f * positionOffset);
                    view2.setAlpha(0.8f + 0.2f * positionOffset);
                } else if (position == 1) {
                    view2.setScaleX(1 - 0.2f * positionOffset);
                    view2.setScaleY(1 - 0.2f * positionOffset);
                    view2.setAlpha(1 - 0.2f * positionOffset);
                    view3.setScaleX(0.8f + 0.2f * positionOffset);
                    view3.setScaleY(0.8f + 0.2f * positionOffset);
                    view3.setAlpha(0.8f + 0.2f * positionOffset);
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
