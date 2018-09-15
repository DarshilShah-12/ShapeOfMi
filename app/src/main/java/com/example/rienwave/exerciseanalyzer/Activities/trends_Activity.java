package com.example.rienwave.exerciseanalyzer.Activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rienwave.exerciseanalyzer.Events.onTrendsBackClickEvent;
import com.example.rienwave.exerciseanalyzer.R;
import com.example.rienwave.exerciseanalyzer.ViewModel.trends_ViewModel;
import com.jjoe64.graphview.GraphView;
import com.example.rienwave.exerciseanalyzer.databinding.TrendsViewBinding;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


// jjoe64/GraphView library is used for displaying trends.
public class trends_Activity extends AppCompatActivity {

    public TrendsViewBinding trendsViewBinding;
    trends_ViewModel trendsViewModel;

    // data binding was not used due to lack of support from the GraphView library
    public GraphView graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trends_view);
        trendsViewModel = new trends_ViewModel(this);

        trendsViewBinding = DataBindingUtil.setContentView(this, R.layout.trends_view);
        trendsViewBinding.setViewModel(trendsViewModel);

        EventBus.getDefault().register(this);

        graph = (GraphView) findViewById(R.id.AvgGraph);
        graph.addSeries(trendsViewModel.getSeriesAvg());
    }

    @Subscribe
    public void onBack(onTrendsBackClickEvent event){
        super.onBackPressed();
    }
}
