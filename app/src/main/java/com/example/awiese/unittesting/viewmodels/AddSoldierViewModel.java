package com.example.awiese.unittesting.viewmodels;

import android.arch.lifecycle.ViewModel;

import com.example.awiese.unittesting.model.SoldierUnitModel;
import com.example.awiese.unittesting.repository.SoldierRepository;
import com.example.awiese.unittesting.utils.SingleLiveEvent;


public class AddSoldierViewModel extends ViewModel {


    private final SoldierRepository soldierRepository;
     final SingleLiveEvent<Boolean> addSoldierEvent = new SingleLiveEvent<>();

    public AddSoldierViewModel(SoldierRepository soldierRepository) {
        this.soldierRepository = soldierRepository;
    }

    public void addNewSoldier(String soldierName, String soldierAlias,
                              String soldierNationality, String soldierUnitClass,
                              int soldierAim, int soldierSpeed, int soldierWill, int soldierDefense) {

        SoldierUnitModel soldierUnitModel = new SoldierUnitModel(soldierName, soldierAlias,
                soldierNationality, soldierUnitClass,
                soldierAim, soldierSpeed, soldierWill, soldierDefense);
        soldierRepository.addSoldier(soldierUnitModel, new SoldierRepository.SoldierRepositoryCallback()
        {
            @Override
            public void onSuccess() {
                addSoldierEvent.setValue(true);
            }

            @Override
            public void onError() {
                addSoldierEvent.setValue(false);
            }
        });
    }

}