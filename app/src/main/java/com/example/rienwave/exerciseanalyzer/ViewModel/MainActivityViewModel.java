package com.example.rienwave.exerciseanalyzer.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;

import com.example.rienwave.exerciseanalyzer.sit_up_count_Activity;


public class MainActivityViewModel extends BaseObservable {

    private Context ActivityContext;

    public MainActivityViewModel(Context context) {
        ActivityContext = context;
    }

        public void onbtnTrackerClick() {
            Intent Invoker = new Intent(ActivityContext, sit_up_count_Activity.class);
            ActivityContext.startActivity(Invoker);
        }

        public void onbtnTrendsClick() {
            // not implemented
        }

}
