package com.example.rienwave.exerciseanalyzer.Model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.rienwave.exerciseanalyzer.Model.sit_up_count_Model;
import com.example.rienwave.exerciseanalyzer.Model.DatabaseHelper;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import static android.content.ContentValues.TAG;

public class trends_Model{

    private LineGraphSeries<DataPoint> SeriesAvg;

    public trends_Model() {
        InitSeries();
    }

    // initilzes Series based on database info
    private void InitSeries() {
        // testing only
        SeriesAvg = new LineGraphSeries<>(new DataPoint[] {
//                new DataPoint(1, 2),
//                new DataPoint(2, 4)
//                new DataPoint(2, 3),
//                new DataPoint(3, 2),
//                new DataPoint(4, 6)
        });
        Cursor cursor = sit_up_count_Model.myDb.getPushUps();
        int count = 0;
        if(cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                count++;
                int y = cursor.getInt(3);
                SeriesAvg.appendData(new DataPoint(count, y), true, 256);
            }
        }
    }

    public LineGraphSeries<DataPoint> getSeriesAvg() {
        return SeriesAvg;
    }

    public void setSeriesAvg(LineGraphSeries<DataPoint> seriesAvg) {
        SeriesAvg = seriesAvg;
    }
}
