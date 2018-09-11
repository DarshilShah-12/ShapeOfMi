package com.example.rienwave.exerciseanalyzer.Activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rienwave.exerciseanalyzer.R;
import com.example.rienwave.exerciseanalyzer.ViewModel.sit_up_count_ViewModel;
import com.example.rienwave.exerciseanalyzer.databinding.SitUpCountViewBinding;
import com.example.rienwave.exerciseanalyzer.Events.onBackClickEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class sit_up_count_Activity extends AppCompatActivity {

    SitUpCountViewBinding mainBinding;
    sit_up_count_ViewModel StiUpCountViewModel;

    //public sit_up_count_Model accelerationVal;
    //public sit_up_count_Model gyroVal;

    public String text_Counter;

    public String StartStopbtnText;

    public int testCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sit_up_count_view);
        StiUpCountViewModel = new sit_up_count_ViewModel(this);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.sit_up_count_view);
        mainBinding.setViewModel(StiUpCountViewModel);

        EventBus.getDefault().register(this);
    }


    // go back to previous activity when a backButtonClick event is raised from the view model
    // listens for event raised by ViewModel
    @Subscribe
    public void onBack(onBackClickEvent event){
        super.onBackPressed();
        //((Activity)this).finish();
    }

}
