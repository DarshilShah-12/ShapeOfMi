package com.example.rienwave.exerciseanalyzer.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.rienwave.exerciseanalyzer.BR;
import com.example.rienwave.exerciseanalyzer.Events.CounterChangedEvent;
import com.example.rienwave.exerciseanalyzer.Events.onTrackerBackClickEvent;
import com.example.rienwave.exerciseanalyzer.Model.push_up_count_Model;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class push_up_count_ViewModel extends BaseObservable{
    private String text_Counter;
    private String StartStopbtnText;

    private push_up_count_Model pushUpCountModel;

    public push_up_count_ViewModel(Context context){
        pushUpCountModel = new push_up_count_Model(context);
        StartStopbtnText = pushUpCountModel.getHasStarted()? "Stop":"Start";
        text_Counter = Integer.toString(pushUpCountModel.getCounter());
        EventBus.getDefault().register(this);
    };

    @Subscribe
    public void onCounterChanged(CounterChangedEvent event){
        setText_Counter(event.getValue());
    }

    public void onStartStopClick(){
        pushUpCountModel.onStartStopClick();
        setStartStopbtnText(pushUpCountModel.getHasStarted() ? "Stop" : "Start");
    }

    public void onBackButtonClick(){
        onTrackerBackClickEvent event = new onTrackerBackClickEvent();
        EventBus.getDefault().post(event);
    }

    @Bindable
    public String getText_Counter() {
        return text_Counter;
    }

    public void setText_Counter(String text_Counter) {
        this.text_Counter = text_Counter;
        notifyPropertyChanged(BR.text_Counter);
    }

    @Bindable
    public String getStartStopbtnText() {
        return StartStopbtnText;
    }

    public void setStartStopbtnText(String startStopbtnText) {
        StartStopbtnText = startStopbtnText;
        notifyPropertyChanged(BR.startStopbtnText);
    }
}
