package com.example.awiese.unittesting.ui;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.awiese.unittesting.R;
import com.example.awiese.unittesting.viewmodels.OrderSoldiersByGroupViewModel;

import java.util.ArrayList;

public class SoldierDisplayFragment extends Fragment {

    private SoldierDisplayAdapter soldierDisplayAdapter;
    private OrderSoldiersByGroupViewModel orderSoldiersByGroupViewModel;


    private Button displayAllSoldiers, displayBestMarksman, displayFastestSoldiers, displayMostStrongWilledSoldiers, displayMostHardenedSoldiers;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display_soldiers, container, false);
        setupRecyclerView(view);
        setupViews(view);
        setupClickListeners();

        return view;
    }

    private void setupClickListeners() {
        displayAllSoldiers.setOnClickListener(v -> setViewModelGetListOfSoldiers());

        displayBestMarksman.setOnClickListener(v -> setViewModelGetListOfBestMarksmenSoldiers());

        displayFastestSoldiers.setOnClickListener(v -> setViewModelGetListOfFastestSoldiers());

        displayMostStrongWilledSoldiers.setOnClickListener(v -> setViewModelGetListOfMostStrongWilledSoldiers());

        displayMostHardenedSoldiers.setOnClickListener(v -> setViewModelGetListOfMostDurableSoldiers());
    }

    private void setupRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_list_soldiers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        soldierDisplayAdapter = new SoldierDisplayAdapter(new ArrayList<>());
        recyclerView.setAdapter(soldierDisplayAdapter);
        final DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    private void setupViews(View view) {
        displayAllSoldiers = view.findViewById(R.id.button_get_all_soldiers);
        displayBestMarksman = view.findViewById(R.id.button_get_best_marksman_soldiers);
        displayFastestSoldiers = view.findViewById(R.id.button_get_fastest_soldiers);
        displayMostStrongWilledSoldiers = view.findViewById(R.id.button_get_most_strong_willed_soldiers);
        displayMostHardenedSoldiers = view.findViewById(R.id.button_get_most_durable_soldiers);

    }

    private void setViewModelGetListOfSoldiers() {
        orderSoldiersByGroupViewModel  =
                ViewModelProviders.of(this).get(OrderSoldiersByGroupViewModel.class);
        orderSoldiersByGroupViewModel.getListOfSoldiers().observe(this, soldierUnitModels -> {
            if (orderSoldiersByGroupViewModel != null) {
                soldierDisplayAdapter.setItems(soldierUnitModels);
            }
        });
        orderSoldiersByGroupViewModel.getListOfSoldiers();
    }

    private void setViewModelGetListOfBestMarksmenSoldiers() {
        orderSoldiersByGroupViewModel  =
                ViewModelProviders.of(this).get(OrderSoldiersByGroupViewModel.class);
        orderSoldiersByGroupViewModel.getListOfBestMarksmenSoldiers().observe(this, soldierUnitModels -> {
            if (orderSoldiersByGroupViewModel != null) {
                soldierDisplayAdapter.setItems(soldierUnitModels);
            }
        });
        orderSoldiersByGroupViewModel.getListOfBestMarksmenSoldiers();
    }

    private void setViewModelGetListOfFastestSoldiers() {
        orderSoldiersByGroupViewModel  =
                ViewModelProviders.of(this).get(OrderSoldiersByGroupViewModel.class);
        orderSoldiersByGroupViewModel.getListOfFastestSoldiers().observe(this, soldierUnitModels -> {
            if (orderSoldiersByGroupViewModel != null) {
                soldierDisplayAdapter.setItems(soldierUnitModels);
            }
        });
        orderSoldiersByGroupViewModel.getListOfFastestSoldiers();
    }

    private void setViewModelGetListOfMostDurableSoldiers() {
        orderSoldiersByGroupViewModel  =
                ViewModelProviders.of(this).get(OrderSoldiersByGroupViewModel.class);
        orderSoldiersByGroupViewModel.getListOfMostDurableSoldiers().observe(this, soldierUnitModels -> {
            if (orderSoldiersByGroupViewModel != null) {
                soldierDisplayAdapter.setItems(soldierUnitModels);
            }
        });
        orderSoldiersByGroupViewModel.getListOfMostDurableSoldiers();
    }

    private void setViewModelGetListOfMostStrongWilledSoldiers() {
        orderSoldiersByGroupViewModel  =
                ViewModelProviders.of(this).get(OrderSoldiersByGroupViewModel.class);
        orderSoldiersByGroupViewModel.getListOfMostStrongWilledSoldiers().observe(this, soldierUnitModels -> {
            if (orderSoldiersByGroupViewModel != null) {
                soldierDisplayAdapter.setItems(soldierUnitModels);
            }
        });
        orderSoldiersByGroupViewModel.getListOfMostStrongWilledSoldiers();
    }
}

