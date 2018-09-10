package com.example.rienwave.exerciseanalyzer;

import android.databinding.BaseObservable;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rienwave.exerciseanalyzer.databinding.SitUpCountViewBinding;

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
    }

}
