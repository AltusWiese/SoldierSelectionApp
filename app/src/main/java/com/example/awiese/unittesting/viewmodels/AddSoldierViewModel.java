package com.example.awiese.unittesting.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.awiese.unittesting.model.SoldierUnitModel;
import com.example.awiese.unittesting.repository.SoldierRepository;


public class AddSoldierViewModel extends ViewModel {


    private SoldierUnitModel soldierUnitModel;
    private SoldierRepository soldierRepository;

    public AddSoldierViewModel(SoldierRepository soldierRepository) {
        this.soldierRepository = soldierRepository;
    }

    public void addNewSoldier(int soldierId, String soldierName, String soldierAlias,
                              String soldierNationality, String soldierUnitClass,
                              int soldierAim, int soldierSpeed, int soldierWill, int soldierDefense) {

        soldierUnitModel = new SoldierUnitModel(soldierId, soldierName, soldierAlias,
                soldierNationality, soldierUnitClass,
                soldierAim, soldierSpeed, soldierWill, soldierDefense);
        soldierRepository.addSoldier(soldierUnitModel, new SoldierRepository.SoldierRepositoryCallback() {
            @Override
            public void onSuccess() {
                Log.d("VM", "onSuccess " + soldierUnitModel.toString());
            }

            @Override
            public void onError() {

            }
        });
    }

}