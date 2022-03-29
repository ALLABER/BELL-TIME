package com.allaber.belltime.ui.schedule;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.allaber.belltime.ui.schedule.ui.WeekFragment;
import com.allaber.belltime.utils.PreferenceManager;

import java.util.List;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return WeekFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        PreferenceManager preferenceManager = new PreferenceManager(mContext);
        List<Integer> selectedDaysOfWeek = preferenceManager.getSelectedDaysOfWeek();
        return mContext.getResources().getString(selectedDaysOfWeek.get(position));
    }

    @Override
    public int getCount() {
        PreferenceManager preferenceManager = new PreferenceManager(mContext);
        List<Integer> selectedDaysOfWeek = preferenceManager.getSelectedDaysOfWeek();
        return selectedDaysOfWeek.size();
    }
}