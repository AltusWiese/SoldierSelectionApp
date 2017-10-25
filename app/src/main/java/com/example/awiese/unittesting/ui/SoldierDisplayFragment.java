package com.example.awiese.unittesting.ui;


import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.awiese.unittesting.R;
import com.example.awiese.unittesting.dao.SoldierDao;
import com.example.awiese.unittesting.db.SoldierDatabase;
import com.example.awiese.unittesting.model.SoldierUnitModel;
import com.example.awiese.unittesting.repository.SoldierRepository;
import com.example.awiese.unittesting.repository.SoldierRepositoryImpl;
import com.example.awiese.unittesting.viewmodels.AddSoldierViewModel;
import com.example.awiese.unittesting.viewmodels.ListAllSoldiersViewModel;
import com.example.awiese.unittesting.viewmodels.ListBestMarksmanSoldiersViewModel;
import com.example.awiese.unittesting.viewmodels.ListFastestSoldiersViewModel;
import com.example.awiese.unittesting.viewmodels.ListMostDurableSoldiersViewModel;
import com.example.awiese.unittesting.viewmodels.ListMostStrongWilledSoldiersViewModel;

import java.util.List;

import static android.content.ContentValues.TAG;

public class SoldierDisplayFragment extends Fragment {

    SoldierDao soldierDao;
    SoldierRepository soldierRepository;
    ListAllSoldiersViewModel listAllSoldiersViewModel;
    ListBestMarksmanSoldiersViewModel listBestMarksmanSoldiersViewModel;
    ListFastestSoldiersViewModel listFastestSoldiersViewModel;
    ListMostStrongWilledSoldiersViewModel listMostStrongWilledSoldiersViewModel;
    ListMostDurableSoldiersViewModel listMostDurableSoldiersViewModel;

    LiveData<List<SoldierUnitModel>> listOfSoldiers;
    private TextView displaySoldierName, displaySoldierAlias, displaySoldierNationality,
            displaySoldierUnitClass, displaySoldierAim, displaySoldierSpeed, displaySoldierWill, displaySoldierDefense;
    private Button displayAllSoldiers, displayBestMarksman, displayFastestSoldiers, displayMostStrongWilledSoldiers, displayMostHardenedSoldiers;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.soldier_display_fragment, container, false);
        setupViews(view);
        setupClickListeners();
        return view;
    }

    private void setupViews(View view) {
        displaySoldierName = view.findViewById(R.id.display_soldier_name);
        displaySoldierAlias = view.findViewById(R.id.display_soldier_alias);
        displaySoldierNationality = view.findViewById(R.id.display_soldier_nationality);
        displaySoldierUnitClass = view.findViewById(R.id.display_soldier_unit_class);
        displaySoldierAim = view.findViewById(R.id.display_soldier_aim);
        displaySoldierSpeed = view.findViewById(R.id.display_soldier_speed);
        displaySoldierWill = view.findViewById(R.id.display_soldier_will);
        displaySoldierDefense = view.findViewById(R.id.display_soldier_defense);
        displayAllSoldiers = view.findViewById(R.id.button_get_all_soldiers);
        displayBestMarksman = view.findViewById(R.id.button_get_best_marksman_soldiers);
        displaySoldierSpeed = view.findViewById(R.id.button_get_fastest_soldiers);
        displaySoldierWill = view.findViewById(R.id.button_get_most_strong_willed_soldiers);
        displayMostHardenedSoldiers = view.findViewById(R.id.button_get_most_durable_soldiers);

    }


    private void setupClickListeners() {
        displayAllSoldiers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getListOfAllSoldiers();
                if (listOfSoldiers != null) {

                    Log.i(TAG, "Displaying soldiers.");
                }
            }
        });
    }

    private LiveData<List<SoldierUnitModel>> getListOfAllSoldiers() {
        soldierDao = SoldierDatabase.getInstance(getContext()).soldierDao();
        soldierRepository = new SoldierRepositoryImpl(soldierDao);
        listAllSoldiersViewModel = new ListAllSoldiersViewModel(soldierRepository);
        listOfSoldiers = listAllSoldiersViewModel.getListOfSoldiers();
        return listOfSoldiers;



    }

}

