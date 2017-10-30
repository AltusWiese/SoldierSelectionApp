package com.example.awiese.unittesting.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.awiese.unittesting.dao.SoldierDao;
import com.example.awiese.unittesting.db.SoldierDatabase;
import com.example.awiese.unittesting.model.SoldierUnitModel;
import com.example.awiese.unittesting.repository.SoldierRepository;
import com.example.awiese.unittesting.repository.SoldierRepositoryImpl;

import java.util.List;

/**
 * Created by AWiese on 2017/10/24.
 */

public class ListMostDurableSoldiersViewModel extends AndroidViewModel {

    private SoldierDao soldierDao;
    private SoldierRepository soldierRepository;
    private LiveData<List<SoldierUnitModel>> listOfSoldiers = new MutableLiveData<>();

    public ListMostDurableSoldiersViewModel(Application application) {
        super(application);


    }

    public LiveData<List<SoldierUnitModel>> getListOfMostDurableSoldiers() {
        soldierDao = SoldierDatabase.getInstance(this.getApplication()).soldierDao();
        soldierRepository = new SoldierRepositoryImpl(soldierDao);
        listOfSoldiers = soldierRepository.listMostDurableSoldiers();
        return listOfSoldiers;
    }
}
