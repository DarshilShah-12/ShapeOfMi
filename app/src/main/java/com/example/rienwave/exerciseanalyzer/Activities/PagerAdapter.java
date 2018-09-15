// Acknowledgement: https://www.truiton.com/2015/06/android-tabs-example-fragments-viewpager/

package com.example.rienwave.exerciseanalyzer.Activities;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.rienwave.exerciseanalyzer.ViewModel.SitUpCounterFragment;
import com.example.rienwave.exerciseanalyzer.ViewModel.PushUpCounterFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    Context Activitycontext;

    public PagerAdapter(FragmentManager fm, int NumOfTabs, Context context) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        Activitycontext = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                SitUpCounterFragment tab1 = SitUpCounterFragment.newInstance(Activitycontext);
                return tab1;
            case 1:
                PushUpCounterFragment tab2 = PushUpCounterFragment.newInstance(Activitycontext);
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}