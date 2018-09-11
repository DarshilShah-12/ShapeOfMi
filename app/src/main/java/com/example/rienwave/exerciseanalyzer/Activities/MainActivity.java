package com.example.rienwave.exerciseanalyzer.Activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.rienwave.exerciseanalyzer.R;
import com.example.rienwave.exerciseanalyzer.ViewModel.MainActivityViewModel;
import com.example.rienwave.exerciseanalyzer.databinding.ActivityMainBinding;


//VM for activity_main
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }


    public void initialize(){
        setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainActivityViewModel = new MainActivityViewModel(this);
        mainBinding.setViewModel(mainActivityViewModel);
    }
}