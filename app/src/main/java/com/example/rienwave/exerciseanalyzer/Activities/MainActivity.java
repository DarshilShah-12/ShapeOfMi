package com.example.rienwave.exerciseanalyzer.Activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import com.example.rienwave.exerciseanalyzer.Model.DatabaseHelper;
import com.example.rienwave.exerciseanalyzer.R;
import com.example.rienwave.exerciseanalyzer.ViewModel.MainActivityViewModel;
import com.example.rienwave.exerciseanalyzer.databinding.ActivityMainBinding;

import java.time.LocalDateTime;


//VM for activity_main
public class MainActivity extends AppCompatActivity {
    EditText editName, editUsername, editPassword;
    Button buttonAddUser;

    ActivityMainBinding mainBinding;
    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initialize();
    }

    public void initialize(){
        setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainActivityViewModel = new MainActivityViewModel(this);
        mainBinding.setViewModel(mainActivityViewModel);
    }

//    public void AddData() {
//        buttonAddUser.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        boolean isInserted = myDb.insertData(editName.getText().toString(), editUsername.getText().toString(), editPassword.getText().toString());
//                        if(isInserted == true)
//                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
//                        else
//                            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
//                    }
//                }
//        );
//        Date date = new Date();
//        myDb.insertData(1,"Sit Ups", 3,1, date);

//    }
}
