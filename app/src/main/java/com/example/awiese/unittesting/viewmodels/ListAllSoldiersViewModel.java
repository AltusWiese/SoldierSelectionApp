package com.example.awiese.unittesting.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.awiese.unittesting.dao.SoldierDao;
import com.example.awiese.unittesting.db.SoldierDatabase;
import com.example.awiese.unittesting.model.SoldierUnitModel;
import com.example.awiese.unittesting.repository.SoldierRepository;
import com.example.awiese.unittesting.repository.SoldierRepositoryImpl;

import java.util.List;


public class ListAllSoldiersViewModel extends ViewModel {


   private SoldierDao soldierDao;
    private SoldierRepository soldierRepository;
    private LiveData<List<SoldierUnitModel>> listOfSoldiers = new LiveData<List<SoldierUnitModel>>() {
    };

    public ListAllSoldiersViewModel(SoldierRepository soldierRepository) {
        this.soldierRepository = soldierRepository;

    }

    public LiveData<List<SoldierUnitModel>> getListOfSoldiers() {

        listOfSoldiers = soldierRepository.listAllSoldiers();
      //  listOfSoldiers = soldierDao.getAllSoldiers();
        return listOfSoldiers;
    }




}
