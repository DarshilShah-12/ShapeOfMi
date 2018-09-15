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
    Date date = new Date(System.currentTimeMillis() - 3600 * 4000);
//    Date currentDate = new Date(System.currentTimeMillis() - 3600 * 4000)

    public static DatabaseHelper myDb;
    EditText editName, editUsername, editPassword;
    Button buttonAddUser;

    ActivityMainBinding mainBinding;
    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        myDb.insertUser("fakename1", "fake_username1", "fake_password_1");
        myDb.insertDateTime(1, date);
        myDb.insertDateTime(2, date);
        myDb.insertData(1,"Sit Ups", 3,1, date);
        myDb.insertData(1,"Push Ups", 300, 2, date);
//        editName = (EditText) findViewById(R.id.editName);
//        editUsername = (EditText) findViewById(R.id.editUsername);
//        editPassword = (EditText) findViewById(R.id.editPassword);
//        buttonAddUser = (Button) findViewById(R.id.buttonAddUser);
//        AddData();
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

    public static DatabaseHelper getDb() {
        return myDb.;
    }
}
