package com.example.rienwave.exerciseanalyzer.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.rienwave.exerciseanalyzer.BR;
import com.example.rienwave.exerciseanalyzer.Events.CounterChangedEvent;
import com.example.rienwave.exerciseanalyzer.Model.sit_up_count_Model;
import com.example.rienwave.exerciseanalyzer.Events.onBackClickEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class sit_up_count_ViewModel extends BaseObservable {

    private String text_Counter;
    private String StartStopbtnText;
    private Context PreviousContext;

    private sit_up_count_Model sitUpCountModel;

    public sit_up_count_ViewModel(Context context){
        PreviousContext = context;
        sitUpCountModel = new sit_up_count_Model(context);
        StartStopbtnText = sitUpCountModel.getHasStarted()? "Stop":"Start";
        text_Counter = Integer.toString(sitUpCountModel.getCounter());
        EventBus.getDefault().register(this);
    };

    @Subscribe
    public void onCounterChanged(CounterChangedEvent event){
        setText_Counter(event.getValue());
    }

    public void onStartStopClick(){
        //testing
        //sitUpCountModel.IncrementCounter();
        //setText_Counter(""+(sitUpCountModel.counter));
        sitUpCountModel.onStartStopClick();
        setStartStopbtnText(sitUpCountModel.getHasStarted() ? "Stop" : "Start");
    }

    // TO DO hook up a onBackClickEvent
    public void onBackButtonClick(){
        onBackClickEvent event = new onBackClickEvent();
        EventBus.getDefault().post(event);
        //finishActivity();
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
