package com.example.li.wardrobe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,
        RadioGroup.OnCheckedChangeListener{

    //UI Objects
    private TextView txt_topBar;
    private RadioGroup rg_tabBar;
    private RadioButton rb_all;
    private RadioButton rb_col;
    private RadioButton rb_set;
    private ViewPager viewPager;

    private MyFragmentPageAdapter mAdapter;

    //代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new MyFragmentPageAdapter(getSupportFragmentManager());
        bindViews();
        rb_all.setChecked(true);
    }

    private void bindViews() {
        //txt_topBar = (TextView) findViewById(R.id.txt_topBar);
        rg_tabBar = (RadioGroup)findViewById(R.id.tabBar);
        rb_all = findViewById(R.id.rb_all);
        rb_col = findViewById(R.id.rb_collect);
        rb_set = findViewById(R.id.rb_set);
        rg_tabBar.setOnCheckedChangeListener(this);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPager.setAdapter(mAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_all:
                viewPager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_collect:
                viewPager.setCurrentItem(PAGE_TWO);
                break;
            case  R.id.rb_set:
                viewPager.setCurrentItem(PAGE_THREE);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0代表什么都没做，1正在滑动，2滑动完毕
        if(state == 2){
            switch (viewPager.getCurrentItem()){
                case PAGE_ONE:
                    rb_all.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_col.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_set.setChecked(true);
                    break;
            }
        }
    }
}
