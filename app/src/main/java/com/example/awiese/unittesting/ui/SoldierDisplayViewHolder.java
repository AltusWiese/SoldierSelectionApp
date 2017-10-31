package com.example.awiese.unittesting.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.awiese.unittesting.R;


class SoldierDisplayViewHolder extends RecyclerView.ViewHolder {

    final TextView soldierNameTextView;
    final TextView soldierAliasTextView;
    final TextView soldierNationalityTextView;
    final TextView soldierUnitClassTextView;
    final TextView soldierAimTextView;
    final TextView soldierSpeedTextView;
    final TextView soldierWillTextView;
    final TextView soldierDefenseTextView;

    SoldierDisplayViewHolder(View soldierListView) {
        super(soldierListView);

        soldierNameTextView = soldierListView.findViewById(R.id.display_soldier_name);
        soldierAliasTextView = soldierListView.findViewById(R.id.display_soldier_alias);
        soldierNationalityTextView = soldierListView.findViewById(R.id.display_soldier_nationality);
        soldierUnitClassTextView = soldierListView.findViewById(R.id.display_soldier_unit_class);
        soldierAimTextView = soldierListView.findViewById(R.id.display_soldier_aim);
        soldierSpeedTextView = soldierListView.findViewById(R.id.display_soldier_speed);
        soldierWillTextView = soldierListView.findViewById(R.id.display_soldier_will);
        soldierDefenseTextView = soldierListView.findViewById(R.id.display_soldier_defense);


    }
}
