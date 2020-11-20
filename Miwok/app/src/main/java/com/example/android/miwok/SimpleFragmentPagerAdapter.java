package com.example.android.miwok;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private final Context mContext;
    private String tabTitles[] = new String[] { "Numbers", "Family", "Colors","Phrases" };
    public SimpleFragmentPagerAdapter(FragmentManager fm, int behaviorResumeOnlyCurrentFragment, Context mContext) {
        super(fm,behaviorResumeOnlyCurrentFragment);
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1){
            return new FamilyFragment();
        } else if (position == 2) {
            return new ColorsFragment();
        }else {
            return new PhrasesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
