package com.example.rienwave.exerciseanalyzer;

import java.util.ArrayList;
import java.util.List;

public class sit_up_count_Model {

    sit_up_count_Model(){
        init();
    }

    private void init(){
        xVal = new ArrayList<Double>();
        yVal = new ArrayList<Double>();
        zVal = new ArrayList<Double>();
    }

    public List<Double> xVal;
    public List<Double> yVal;
    public List<Double> zVal;
}
