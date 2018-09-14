package com.example.rienwave.exerciseanalyzer.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;

import com.example.rienwave.exerciseanalyzer.Activities.sit_up_count_Activity;
import com.example.rienwave.exerciseanalyzer.Events.onTrackerBackClickiEvent;
import com.example.rienwave.exerciseanalyzer.Events.onTrendsBackClickEvent;
import com.example.rienwave.exerciseanalyzer.Model.trends_Model;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.greenrobot.eventbus.EventBus;


public class trends_ViewModel extends BaseObservable{

    private LineGraphSeries<DataPoint> SeriesAvg;
    private trends_Model trendsModel;
    private Context ActivityContext;

    public trends_ViewModel(Context context) {
        ActivityContext = context;
        trendsModel = new trends_Model();
        SeriesAvg = trendsModel.getSeriesAvg();
    }

    public LineGraphSeries<DataPoint> getSeriesAvg() {
        return SeriesAvg;
    }

    public void setSeriesAvg(LineGraphSeries<DataPoint> seriesAvg) {
        SeriesAvg = seriesAvg;
    }

    public void onBackButtonClick(){
        onTrendsBackClickEvent event = new onTrendsBackClickEvent();
        EventBus.getDefault().post(event);
    }

    public void onTrackerButtonClick(){
        Intent Invoker = new Intent(ActivityContext, sit_up_count_Activity.class);
        ActivityContext.startActivity(Invoker);
    }
}
