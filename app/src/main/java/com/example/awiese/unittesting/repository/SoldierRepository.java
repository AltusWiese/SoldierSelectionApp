package com.example.awiese.unittesting.repository;

import android.arch.lifecycle.LiveData;

import com.example.awiese.unittesting.model.SoldierUnitModel;

import java.util.List;

public interface SoldierRepository {

    void addSoldier(SoldierUnitModel soldierUnitModel, SoldierRepositoryCallback callback);

    interface SoldierRepositoryCallback {
        void onSuccess();
        void onError();

    }

    LiveData<List<SoldierUnitModel>> listAllSoldiers();

    LiveData<List<SoldierUnitModel>> listBestMarksmanSoldiers();

    LiveData<List<SoldierUnitModel>> listFastestSoldiers();

    LiveData<List<SoldierUnitModel>> listMostDurableSoldiers();

    LiveData<List<SoldierUnitModel>> listMostStrongWilledSoldiers();
}
