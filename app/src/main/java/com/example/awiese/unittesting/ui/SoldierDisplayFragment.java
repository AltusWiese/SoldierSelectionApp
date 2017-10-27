package com.example.awiese.unittesting.ui;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.awiese.unittesting.R;
import com.example.awiese.unittesting.SoldierApplication;
import com.example.awiese.unittesting.dao.SoldierDao;
import com.example.awiese.unittesting.model.SoldierUnitModel;
import com.example.awiese.unittesting.repository.SoldierRepository;
import com.example.awiese.unittesting.viewmodels.ListAllSoldiersViewModel;
import com.example.awiese.unittesting.viewmodels.ListBestMarksmanSoldiersViewModel;
import com.example.awiese.unittesting.viewmodels.ListFastestSoldiersViewModel;
import com.example.awiese.unittesting.viewmodels.ListMostDurableSoldiersViewModel;
import com.example.awiese.unittesting.viewmodels.ListMostStrongWilledSoldiersViewModel;

import java.util.ArrayList;
import java.util.List;

public class SoldierDisplayFragment extends Fragment {

    private static final String TAG = "SoldierDisplayFragment";
    private SoldierDisplayAdapter soldierDisplayAdapter;
    SoldierDao soldierDao;
    SoldierRepository soldierRepository;
    ListAllSoldiersViewModel listAllSoldiersViewModel;
    ListBestMarksmanSoldiersViewModel listBestMarksmanSoldiersViewModel;
    ListFastestSoldiersViewModel listFastestSoldiersViewModel;
    ListMostStrongWilledSoldiersViewModel listMostStrongWilledSoldiersViewModel;
    ListMostDurableSoldiersViewModel listMostDurableSoldiersViewModel;

    private View.OnClickListener onClickListener = v -> {
        //ListAllSoldiersViewModel soldiers = (ListAllSoldiersViewModel) v.getTag();
        listAllSoldiersViewModel.getListOfSoldiers();
    };


    LiveData<List<SoldierUnitModel>> listOfSoldiers;
    private TextView displaySoldierName, displaySoldierAlias, displaySoldierNationality,
            displaySoldierUnitClass, displaySoldierAim, displaySoldierSpeed, displaySoldierWill, displaySoldierDefense;
    private Button displayAllSoldiers, displayBestMarksman, displayFastestSoldiers, displayMostStrongWilledSoldiers, displayMostHardenedSoldiers;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.soldier_display_fragment, container, false);
        setupRecyclerView(view);
      //  setupViews(view);
        SoldierApplication.getSoldierRepository();
     //   listAllSoldiersViewModel = ViewModelProviders.of(this).get(ListAllSoldiersViewModel.class);
//        listAllSoldiersViewModel.getListOfSoldiers().observe(this, soldierList -> {
//            Log.d(TAG, "Events Changed:" + soldierList);
//            soldierDisplayAdapter.setItems(soldierList);
//        });
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         listAllSoldiersViewModel  =
                ViewModelProviders.of(this).get(ListAllSoldiersViewModel.class);
        listAllSoldiersViewModel.getListOfSoldiers().observe(this, soldierUnitModels -> {
            if (listAllSoldiersViewModel != null) {
                soldierDisplayAdapter.setItems((ArrayList<SoldierUnitModel>) soldierUnitModels);
            }
            });
    }

    private void setupRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_list_soldiers);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        soldierDisplayAdapter = new SoldierDisplayAdapter(new ArrayList<>(), getContext(), onClickListener);
        recyclerView.setAdapter(soldierDisplayAdapter);
        final DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

//    private void setupViews(View view) {
//        displaySoldierName = view.findViewById(R.id.display_soldier_name);
//        displaySoldierAlias = view.findViewById(R.id.display_soldier_alias);
//        displaySoldierNationality = view.findViewById(R.id.display_soldier_nationality);
//        displaySoldierUnitClass = view.findViewById(R.id.display_soldier_unit_class);
//        displaySoldierAim = view.findViewById(R.id.display_soldier_aim);
//        displaySoldierSpeed = view.findViewById(R.id.display_soldier_speed);
//        displaySoldierWill = view.findViewById(R.id.display_soldier_will);
//        displaySoldierDefense = view.findViewById(R.id.display_soldier_defense);
//        displayAllSoldiers = view.findViewById(R.id.button_get_all_soldiers);
//        displayBestMarksman = view.findViewById(R.id.button_get_best_marksman_soldiers);
//        displaySoldierSpeed = view.findViewById(R.id.button_get_fastest_soldiers);
//        displaySoldierWill = view.findViewById(R.id.button_get_most_strong_willed_soldiers);
//        displayMostHardenedSoldiers = view.findViewById(R.id.button_get_most_durable_soldiers);
//
//    }

}

