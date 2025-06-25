package com.dalazu.bteb.utils;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dalazu.bteb.regulation.RegulationTenFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> fragmentsTitle = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Log.d("TAG", "getItemPosition: " + position);
        return fragments.get(position);

    }

    @Override
    public int getCount() {
        Log.d("DDDDD", "getCount: " + fragments.size());
        return fragments.size();
    }

    public void addFragment(Fragment fragment, String title) {
        fragments.add(fragment);
        fragmentsTitle.add(title);

        Log.d("GGGG", "addFragment: " + fragment.toString() + title.toString());

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Log.d("FFFFF", "getPageTitle: " + fragmentsTitle.toString());
        return fragmentsTitle.get(position);
    }
}
