package com.example.rienwave.exerciseanalyzer.ViewModel;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rienwave.exerciseanalyzer.R;
import com.example.rienwave.exerciseanalyzer.databinding.PushUpCounterViewBinding;

public class PushUpCounterFragment extends Fragment {

    private static Context ActivityContext;
    PushUpCounterViewBinding mainBinding;
    push_up_count_ViewModel PushUpCountViewModel;


    public String text_Counter;

    public static PushUpCounterFragment newInstance(Context context) {

        Bundle args = new Bundle();
        ActivityContext = context;

        PushUpCounterFragment fragment = new PushUpCounterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        PushUpCountViewModel = new push_up_count_ViewModel(ActivityContext);
        mainBinding = DataBindingUtil.inflate(
                inflater, R.layout.push_up_counter_view, container, false);
        mainBinding.setViewModel(PushUpCountViewModel);
        View view = mainBinding.getRoot();
        return view;
    }
}
