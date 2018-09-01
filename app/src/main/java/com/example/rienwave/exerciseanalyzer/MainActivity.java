package com.example.rienwave.exerciseanalyzer;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rienwave.exerciseanalyzer.databinding.ActivityMainBinding;


//VM for activity_main
public class MainActivity extends AppCompatActivity {
    Button btnMainTemp;
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
    }

    public void initialize(){
        setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setViewModel(this);
    }

    public void onbtnNextClick() {
        Intent Invoker = new Intent(MainActivity.this, sit_up_count_ViewModel.class);
        startActivity(Invoker);
    }
}
