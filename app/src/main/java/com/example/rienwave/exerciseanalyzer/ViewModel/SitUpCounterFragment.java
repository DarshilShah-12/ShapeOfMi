package com.example.rienwave.exerciseanalyzer.ViewModel;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rienwave.exerciseanalyzer.R;
import com.example.rienwave.exerciseanalyzer.databinding.SitUpCountViewBinding;

import static android.databinding.DataBindingUtil.setContentView;

public class SitUpCounterFragment extends Fragment {


    private static Context ActivityContext;
    SitUpCountViewBinding mainBinding;
    sit_up_count_ViewModel StiUpCountViewModel;

    public String text_Counter;

    public static SitUpCounterFragment newInstance(Context context) {

        Bundle args = new Bundle();
        ActivityContext = context;

        SitUpCounterFragment fragment = new SitUpCounterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        StiUpCountViewModel = new sit_up_count_ViewModel(ActivityContext);
        mainBinding = DataBindingUtil.inflate(
                inflater, R.layout.sit_up_count_view, container, false);
        //mainBinding = setContentView((Activity) ActivityContext, R.layout.sit_up_count_view);
        mainBinding.setViewModel(StiUpCountViewModel);
        View view = mainBinding.getRoot();

        return view;
    }
}