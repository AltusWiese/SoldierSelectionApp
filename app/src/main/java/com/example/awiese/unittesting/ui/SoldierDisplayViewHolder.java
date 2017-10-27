package com.example.awiese.unittesting.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.awiese.unittesting.R;

/**
 * Created by AWiese on 2017/10/24.
 */

public class SoldierDisplayViewHolder extends RecyclerView.ViewHolder {

    TextView soldierNameTextView;
    TextView soldierAliasTextView;
    TextView soldierNationalityTextView;
    TextView soldierUnitClassTextView;
    TextView soldierAimTextView;
    TextView soldierSpeedTextView;
    TextView soldierWillTextView;
    TextView soldierDefenseTextView;

    public SoldierDisplayViewHolder(View soldierListView) {
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
