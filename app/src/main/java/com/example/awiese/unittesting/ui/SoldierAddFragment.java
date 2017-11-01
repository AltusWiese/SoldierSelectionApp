package com.example.awiese.unittesting.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.awiese.unittesting.R;
import com.example.awiese.unittesting.dao.SoldierDao;
import com.example.awiese.unittesting.db.SoldierDatabase;
import com.example.awiese.unittesting.repository.SoldierRepository;
import com.example.awiese.unittesting.repository.SoldierRepositoryImpl;
import com.example.awiese.unittesting.viewmodels.AddSoldierViewModel;

import java.util.Random;

public class SoldierAddFragment extends Fragment {

    private static final String TAG = "SoldierAddFragment";
    private EditText addSoldierName, addSoldierAlias, addSoldierNationality, addSoldierUnitClass;
    private Button addSoldierButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_new_soldier, container, false);
        setupViews(view);
        setupClickListeners();
        return view;
    }

    private void setupClickListeners() {
        addSoldierButton.setOnClickListener(v -> {
            addNewSoldier();
            Toast.makeText(getContext(), "Added Soldier " + addSoldierName.getText().toString() + " to database.", Toast.LENGTH_LONG).show();
            clearTextViews();

        });
    }

    private void clearTextViews() {
        addSoldierName.setText("");
        addSoldierAlias.setText("");
        addSoldierNationality.setText("");
        addSoldierUnitClass.setText("");
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

        SoldierDao soldierDao = SoldierDatabase.getInstance(getContext()).soldierDao();
        SoldierRepository soldierRepository = new SoldierRepositoryImpl(soldierDao);
        AddSoldierViewModel addSoldierViewModel = new AddSoldierViewModel(soldierRepository);

        addSoldierViewModel.addNewSoldier(soldierName, soldierAlias, soldierNationality,
                soldierUnitClass, soldierAim, soldierSpeed, soldierWill, soldierDefense);
    }

    private int randomStatsGenerator() {
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
