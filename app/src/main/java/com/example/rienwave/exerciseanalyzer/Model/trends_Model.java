package com.example.rienwave.exerciseanalyzer.Model;

import com.example.rienwave.exerciseanalyzer.Activities.MainActivity;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class trends_Model{

    private LineGraphSeries<DataPoint> SeriesAvg;

    public trends_Model() {
        InitSeries();
    }

    // initilzes Series based on database info
    private void InitSeries() {
        // testing only
        SeriesAvg = new LineGraphSeries<>(new DataPoint[] {
//                new DataPoint(0, 1),
//                new DataPoint(1, 5),
//                new DataPoint(2, 3),
//                new DataPoint(3, 2),
//                new DataPoint(4, 6)
        });
    }

    public LineGraphSeries<DataPoint> getSeriesAvg() {
        return SeriesAvg;
    }

    public void setSeriesAvg(LineGraphSeries<DataPoint> seriesAvg) {
        SeriesAvg = seriesAvg;
    }
}
