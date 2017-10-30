package com.example.awiese.unittesting.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.awiese.unittesting.R;
import com.example.awiese.unittesting.dao.SoldierDao;
import com.example.awiese.unittesting.db.SoldierDatabase;
import com.example.awiese.unittesting.repository.SoldierRepository;
import com.example.awiese.unittesting.repository.SoldierRepositoryImpl;
import com.example.awiese.unittesting.viewmodels.AddSoldierViewModel;

import java.util.Random;

public class SoldierAddFragment extends Fragment {

    private static final String TAG = "SoldierAddFragment";
    AddSoldierViewModel addSoldierViewModel;
    SoldierDao soldierDao;
    SoldierRepository soldierRepository;
    private EditText addSoldierName, addSoldierAlias, addSoldierNationality, addSoldierUnitClass;
    private Button addSoldierButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.soldier_add_new_fragment, container, false);
        setupViews(view);
        setupClickListeners();
        return view;
    }

    private void setupClickListeners() {
        addSoldierButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewSoldier();
                Log.i(TAG, "Added a new soldier.");
            }
        });
    }

    private void addNewSoldier() {
        String soldierName = addSoldierName.getText().toString();
        String soldierAlias = addSoldierAlias.getText().toString();
        String soldierNationality = addSoldierNationality.getText().toString();
        String soldierUnitClass = addSoldierUnitClass.getText().toString();
        int soldierAim = randomStatsGenerator();
        int soldierSpeed = randomStatsGenerator();
        int soldierWill = randomStatsGenerator();
        int soldierDefense = randomStatsGenerator();

        soldierDao = SoldierDatabase.getInstance(getContext()).soldierDao();
        soldierRepository = new SoldierRepositoryImpl(soldierDao);
        addSoldierViewModel = new AddSoldierViewModel(soldierRepository);

        addSoldierViewModel.addNewSoldier(soldierName, soldierAlias, soldierNationality,
                soldierUnitClass, soldierAim, soldierSpeed, soldierWill, soldierDefense);
    }

    public int randomStatsGenerator() {
        Random randomStatGenerator = new Random();
        return randomStatGenerator.nextInt(90 - 20) + 20;
    }

    private void setupViews(View view) {
        addSoldierName = view.findViewById(R.id.add_soldier_name);
        addSoldierAlias = view.findViewById(R.id.add_soldier_alias);
        addSoldierNationality = view.findViewById(R.id.add_soldier_nationality);
        addSoldierUnitClass = view.findViewById(R.id.add_soldier_unit_class);
        addSoldierButton = view.findViewById(R.id.add_soldier_button);

    }
}
