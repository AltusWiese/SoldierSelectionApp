package com.example.awiese.unittesting.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.awiese.unittesting.R;
import com.example.awiese.unittesting.model.SoldierUnitModel;

import java.util.List;

 class SoldierDisplayAdapter extends RecyclerView.Adapter<SoldierDisplayViewHolder> {

    private List<SoldierUnitModel> listOfAllSoldiers;


    SoldierDisplayAdapter(List<SoldierUnitModel> listOfAllSoldiers) {
        this.listOfAllSoldiers = listOfAllSoldiers;

    }
    @Override
    public SoldierDisplayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_soldier_list, parent, false);
        return new SoldierDisplayViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SoldierDisplayViewHolder holder, int position) {
    SoldierUnitModel soldierUnitModel = listOfAllSoldiers.get(position);
    holder.soldierNameTextView.setText(soldierUnitModel.getSoldierName());
    holder.soldierAliasTextView.setText(soldierUnitModel.getSoldierAlias());
    holder.soldierNationalityTextView.setText(soldierUnitModel.getSoldierNationality());
    holder.soldierUnitClassTextView.setText(soldierUnitModel.getSoldierUnitClass());
    holder.soldierAimTextView.setText(String.valueOf(soldierUnitModel.getSoldierAim()));
    holder.soldierSpeedTextView.setText(String.valueOf(soldierUnitModel.getSoldierSpeed()));
    holder.soldierWillTextView.setText(String.valueOf(soldierUnitModel.getSoldierWill()));
    holder.soldierDefenseTextView.setText(String.valueOf(soldierUnitModel.getSoldierDefense()));
    }

    @Override
    public int getItemCount() {
        return listOfAllSoldiers.size();
    }
    void setItems(List<SoldierUnitModel> soldiers) {
        this.listOfAllSoldiers = soldiers;
        notifyDataSetChanged();
    }


}
