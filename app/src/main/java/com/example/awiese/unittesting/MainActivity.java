package com.example.awiese.unittesting;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.example.awiese.unittesting.model.SoldierUnitModel;

import java.util.List;

public class MainActivity extends FragmentActivity {

    private ViewModel viewModel;
    LiveData<List<SoldierUnitModel>> listOfSoldiers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
//
//        final Observer<List<SoldierUnitModel>> soldierUnitModelObserver = new Observer<List<SoldierUnitModel>>() {
//            @Override
//            public void onChanged(@Nullable List<SoldierUnitModel> soldierUnitModels) {
//
//            }
//
//        };
    }
}
