package com.example.awiese.unittesting.viewmodels;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.awiese.unittesting.dao.SoldierDao;
import com.example.awiese.unittesting.db.SoldierDatabase;
import com.example.awiese.unittesting.model.SoldierUnitModel;
import com.example.awiese.unittesting.repository.SoldierRepository;
import com.example.awiese.unittesting.repository.SoldierRepositoryImpl;

import java.util.List;

public class OrderSoldiersByGroupViewModel extends AndroidViewModel {

    public OrderSoldiersByGroupViewModel(Application application) {
        super(application);
    }

    public LiveData<List<SoldierUnitModel>> getListOfSoldiers() {
        SoldierDao soldierDao = SoldierDatabase.getInstance(this.getApplication()).soldierDao();
        SoldierRepository soldierRepository = new SoldierRepositoryImpl(soldierDao);
        return soldierRepository.listAllSoldiers();
    }

    public LiveData<List<SoldierUnitModel>> getListOfBestMarksmenSoldiers() {
        SoldierDao soldierDao = SoldierDatabase.getInstance(this.getApplication()).soldierDao();
        SoldierRepository soldierRepository = new SoldierRepositoryImpl(soldierDao);
        return soldierRepository.listBestMarksmanSoldiers();
    }

    public LiveData<List<SoldierUnitModel>> getListOfFastestSoldiers() {
        SoldierDao soldierDao = SoldierDatabase.getInstance(this.getApplication()).soldierDao();
        SoldierRepository soldierRepository = new SoldierRepositoryImpl(soldierDao);
        return soldierRepository.listFastestSoldiers();
    }

    public LiveData<List<SoldierUnitModel>> getListOfMostDurableSoldiers() {
        SoldierDao soldierDao = SoldierDatabase.getInstance(this.getApplication()).soldierDao();
        SoldierRepository soldierRepository = new SoldierRepositoryImpl(soldierDao);
        return soldierRepository.listMostDurableSoldiers();
    }

    public LiveData<List<SoldierUnitModel>> getListOfMostStrongWilledSoldiers() {
        SoldierDao soldierDao = SoldierDatabase.getInstance(this.getApplication()).soldierDao();
        SoldierRepository soldierRepository = new SoldierRepositoryImpl(soldierDao);
        return soldierRepository.listMostStrongWilledSoldiers();
    }
}
