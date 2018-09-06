package com.example.rienwave.exerciseanalyzer;

import android.databinding.DataBindingUtil;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rienwave.exerciseanalyzer.databinding.SitUpCountViewBinding;

import java.util.ArrayList;

public class sit_up_count_ViewModel extends AppCompatActivity implements SensorEventListener{

    SitUpCountViewBinding mainBinding;

    public Values accelerationVal;
    public Values gyroVal;
    public String text_Counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sit_up_count_view);
        Initialize();
    }
    private void Initialize(){
        accelerationVal = new Values();
        mainBinding = DataBindingUtil.setContentView(this, R.layout.sit_up_count_view);
        mainBinding.setViewModel(this);

        SensorManager asensorM = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor asensor = asensorM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        asensorM.registerListener(this, asensor, SensorManager.SENSOR_DELAY_NORMAL);

        SensorManager gsensorM = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor gSensor = gsensorM.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        gsensorM.registerListener(this, gSensor, SensorManager.SENSOR_DELAY_NORMAL);
    };

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if (sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            accelerationVal.xVal.add((double)Math.round(event.values[0] * 100d) / 100d);
            accelerationVal.yVal.add((double)Math.round(event.values[1] * 100d) / 100d);
            accelerationVal.zVal.add((double)Math.round(event.values[2] * 100d) / 100d);
            accelerationVal = Analyze(accelerationVal);
        }
        else if (sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            gyroVal.xVal.add((double)Math.round(event.values[0] * 100d) / 100d);
            gyroVal.yVal.add((double)Math.round(event.values[0] * 100d) / 100d);
            gyroVal.zVal.add((double)Math.round(event.values[0] * 100d) / 100d);
            gyroVal = Analyze(gyroVal);
        }
    }

    public Values Analyze (Values values){

        // ToDO determine if text_Counter needs to be incremented
        // TODO clear the ArrayLIst with every new sit-up

        return values;
    }



    // Not Implemented
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
}
