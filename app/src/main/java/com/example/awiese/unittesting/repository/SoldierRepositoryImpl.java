package com.example.awiese.unittesting.repository;

import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.example.awiese.unittesting.dao.SoldierDao;
import com.example.awiese.unittesting.model.SoldierUnitModel;

import java.util.List;


public class SoldierRepositoryImpl implements SoldierRepository {

    private final SoldierDao soldierDao;
    private LiveData<List<SoldierUnitModel>> listOfSoldiers;
    private final int bestSoldiers = 75;

    public SoldierRepositoryImpl(SoldierDao soldierDao) {
        this.soldierDao = soldierDao;
    }

    @Override
    public void addSoldier(SoldierUnitModel soldierUnitModel, SoldierRepositoryCallback callback) {
        final SoldierAsyncTask soldierAsyncTask = new SoldierAsyncTask(callback, soldierDao);
        soldierAsyncTask.execute(soldierUnitModel);
    }

    @Override
    public LiveData<List<SoldierUnitModel>> listAllSoldiers() {
        listOfSoldiers = soldierDao.getAllSoldiers();
        return listOfSoldiers;
    }

    @Override
    public LiveData<List<SoldierUnitModel>> listBestMarksmanSoldiers() {
        listOfSoldiers = soldierDao.getBestMarksmanSoldiers(bestSoldiers);
        return listOfSoldiers;
    }

    @Override
    public LiveData<List<SoldierUnitModel>> listFastestSoldiers() {
        listOfSoldiers = soldierDao.getFastestSoldiers(bestSoldiers);
        return listOfSoldiers;
    }

    @Override
    public LiveData<List<SoldierUnitModel>> listMostDurableSoldiers() {
        listOfSoldiers = soldierDao.getMostHardenedSoldiers(bestSoldiers);
        return listOfSoldiers;
    }

    @Override
    public LiveData<List<SoldierUnitModel>> listMostStrongWilledSoldiers() {
        listOfSoldiers = soldierDao.getMostStrongWilledSoldiers(bestSoldiers);
        return listOfSoldiers;
    }

    private static class SoldierAsyncTask extends AsyncTask<SoldierUnitModel, Void, Void> {

        private boolean callbackSuccess;
        private final SoldierDao soldierDao;
        private final SoldierRepositoryCallback soldierRepositoryCallback;

        SoldierAsyncTask(SoldierRepositoryCallback callback, SoldierDao soldierDao) {
            soldierRepositoryCallback = callback;
            this.soldierDao = soldierDao;
            if (soldierRepositoryCallback != null) {
                callbackSuccess = true;
            }

        }

        @Override
        protected Void doInBackground(SoldierUnitModel... soldierUnitModels) {
            soldierDao.addNewSoldier(soldierUnitModels[0]);
            Log.d("SoldierRepoAsync", "I was created!");
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (callbackSuccess) {
                soldierRepositoryCallback.onSuccess();
            } else {
                soldierRepositoryCallback.onError();
            }
        }
    }
}
