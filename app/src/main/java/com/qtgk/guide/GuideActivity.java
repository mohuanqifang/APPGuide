package com.qtgk.guide;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.qtgk.guide.adapter.MyViewPagerAdapter;
import com.qtgk.guide.fragment.GuideFirstFragment;
import com.qtgk.guide.fragment.GuideFourFragment;
import com.qtgk.guide.fragment.GuideSecondFragment;
import com.qtgk.guide.fragment.GuideThirdFragment;

import java.util.ArrayList;

public class GuideActivity extends FragmentActivity {

    private ArrayList<Fragment> list;
    private ViewPager mViewPager;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        mSharedPreferences = getSharedPreferences("", Context.MODE_PRIVATE);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        findViewById(R.id.tv_skip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                SharedPreferences.Editor mEditor = mSharedPreferences.edit();
                mEditor.putBoolean("launcher", false);
                mEditor.commit();
            }
        });
        list = new ArrayList<>();
        GuideFirstFragment mGuideFirstFragment = new GuideFirstFragment();
        GuideSecondFragment mGuideSecondFragment = new GuideSecondFragment();
        GuideThirdFragment mGuideThirdFragment = new GuideThirdFragment();
        GuideFourFragment mGuideFourFragment = new GuideFourFragment();
        list.add(0, mGuideFirstFragment);
        list.add(1, mGuideSecondFragment);
        list.add(2, mGuideThirdFragment);
        list.add(3, mGuideFourFragment);
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(), list);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(0);
//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }

}
