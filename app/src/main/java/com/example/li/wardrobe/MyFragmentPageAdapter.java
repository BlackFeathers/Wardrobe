package com.example.li.wardrobe;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MyFragmentPageAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 3;
    private Frag1 frag1 = null;
    private Frag2 frag2 = null;
    private Frag3 frag3 = null;

    public MyFragmentPageAdapter(android.support.v4.app.FragmentManager fm){
        super(fm);
        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destroy"+position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case MainActivity.PAGE_ONE:
                fragment = frag1;
                break;
            case MainActivity.PAGE_TWO:
                fragment = frag2;
                break;
            case MainActivity.PAGE_THREE:
                fragment = frag3;
                break;
        }
        return fragment;
    }
}
