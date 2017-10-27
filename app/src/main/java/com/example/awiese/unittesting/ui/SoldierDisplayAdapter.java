package com.example.awiese.unittesting.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.awiese.unittesting.R;
import com.example.awiese.unittesting.model.SoldierUnitModel;

import java.util.ArrayList;

public class SoldierDisplayAdapter extends RecyclerView.Adapter<SoldierDisplayViewHolder> {

    private final Context context;
    private ArrayList<SoldierUnitModel> listOfAllSoldiers;
    private View.OnClickListener showAllSoldiersClickListener;


    SoldierDisplayAdapter(ArrayList<SoldierUnitModel> listOfAllSoldiers,Context context, View.OnClickListener showAllSoldiersClickListener) {
        this.listOfAllSoldiers = listOfAllSoldiers;
        this.context = context;
        this.showAllSoldiersClickListener = showAllSoldiersClickListener;
    }
    @Override
    public SoldierDisplayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.individual_soldier_data_view, parent, false);
        return new SoldierDisplayViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SoldierDisplayViewHolder holder, int position) {
    SoldierUnitModel soldierUnitModel = listOfAllSoldiers.get(position);
    holder.soldierNameTextView.setText(soldierUnitModel.getSoldierName().toString());
    holder.soldierAliasTextView.setText(soldierUnitModel.getSoldierAlias());
    holder.soldierNationalityTextView.setText(soldierUnitModel.getSoldierNationality());
    holder.soldierUnitClassTextView.setText(soldierUnitModel.getSoldierUnitClass());
    holder.soldierAimTextView.setText(soldierUnitModel.getSoldierAim());
    holder.soldierSpeedTextView.setText(soldierUnitModel.getSoldierSpeed());
    holder.soldierWillTextView.setText(soldierUnitModel.getSoldierWill());
    holder.soldierDefenseTextView.setText(soldierUnitModel.getSoldierDefense());
    }

    @Override
    public int getItemCount() {
        return listOfAllSoldiers.size();
    }
    void setItems(ArrayList<SoldierUnitModel> soldiers) {
        this.listOfAllSoldiers = soldiers;
        notifyDataSetChanged();
    }
}
