package com.example.rienwave.exerciseanalyzer.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.rienwave.exerciseanalyzer.BR;
import com.example.rienwave.exerciseanalyzer.Events.SitUpCounterChangedEvent;
import com.example.rienwave.exerciseanalyzer.Events.onPushUpDetailsVisibilityChanged;
import com.example.rienwave.exerciseanalyzer.Model.sit_up_count_Model;
import com.example.rienwave.exerciseanalyzer.Events.onTrackerBackClickEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class sit_up_count_ViewModel extends BaseObservable {

    private String text_Counter;
    private String StartStopbtnText;
    private sit_up_count_Model sitUpCountModel;

    public sit_up_count_ViewModel(Context context){
        sitUpCountModel = new sit_up_count_Model(context);
        StartStopbtnText = sitUpCountModel.getHasStarted()? "Stop":"Start";
        text_Counter = Integer.toString(sitUpCountModel.getCounter());
        EventBus.getDefault().register(this);
    };

    @Subscribe
    public void onCounterChanged(SitUpCounterChangedEvent event){
        setText_Counter(event.getValue());
    }

    public void onStartStopClick(){
        sitUpCountModel.onStartStopClick();
        setStartStopbtnText(sitUpCountModel.getHasStarted() ? "Stop" : "Start");
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

    public void onfabClearClick(){
        sitUpCountModel.ClearCount();
    }

    public void onStopClick(){
        sitUpCountModel.onStopClick();
    }

    public void onDetailsbtnClick() {
        onPushUpDetailsVisibilityChanged event = new onPushUpDetailsVisibilityChanged();
        EventBus.getDefault().post(event);
    }
}
