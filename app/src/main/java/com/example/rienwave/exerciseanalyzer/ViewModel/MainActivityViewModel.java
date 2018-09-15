package com.example.rienwave.exerciseanalyzer.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;

import com.example.rienwave.exerciseanalyzer.Activities.CounterActivity;
import com.example.rienwave.exerciseanalyzer.Activities.sit_up_count_Activity;
import com.example.rienwave.exerciseanalyzer.Activities.trends_Activity;


public class MainActivityViewModel extends BaseObservable {

    private Context ActivityContext;

    public MainActivityViewModel(Context context) {
        ActivityContext = context;
    }

        public void onbtnTrendsClick() {
            Intent Invoker = new Intent(ActivityContext, trends_Activity.class);
            ActivityContext.startActivity(Invoker);
        }
        public void onbtnTrackerClick(){
            Intent Invoker = new Intent(ActivityContext, CounterActivity.class);
            ActivityContext.startActivity(Invoker);
        }
}