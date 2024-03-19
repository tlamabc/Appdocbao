package com.example.appdocbao;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    int tabcount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TrangchuFragment();
            case 1:
                return new ThethaoFragment();
            case 2:
                return new SuckhoeFragment();
            case 3:
                return new KhoahocFragment();
            case 4:
                return new GiaitriFragment();
            case 5:
                return new CongngheFragment();
            case 6:
                return new AmnhacFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
