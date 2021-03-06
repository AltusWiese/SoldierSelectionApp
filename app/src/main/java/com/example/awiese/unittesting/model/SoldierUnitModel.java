package com.example.awiese.unittesting.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import static com.example.awiese.unittesting.model.SoldierUnitModel.TABLE_NAME;


@Entity(tableName = TABLE_NAME)
public class SoldierUnitModel {

    public static final String TABLE_NAME = "soldier_list";
    public static final String SOLDIER_AIM = "soldier_aim";
    public static final String SOLDIER_SPEED = "soldier_speed";
    public static final String SOLDIER_WILL = "soldier_will";
    public static final String SOLDIER_DEFENSE = "soldier_defense";

    @PrimaryKey(autoGenerate = true)
    private int soldierId;
    private final String soldierName;
    private final String soldierAlias;
    private final String soldierNationality;
    private final String soldierUnitClass;
    @ColumnInfo(name = SOLDIER_AIM)
    private final int soldierAim;
    @ColumnInfo(name = SOLDIER_SPEED)
    private final int soldierSpeed;
    @ColumnInfo(name = SOLDIER_WILL)
    private final int soldierWill;
    @ColumnInfo(name = SOLDIER_DEFENSE)
    private final int soldierDefense;

    public SoldierUnitModel(int soldierId, String soldierName, String soldierAlias, String soldierNationality, String soldierUnitClass,
                            int soldierAim, int soldierSpeed, int soldierWill, int soldierDefense) {
        this.soldierId = soldierId;
        this.soldierName = soldierName;
        this.soldierAlias = soldierAlias;
        this.soldierNationality = soldierNationality;
        this.soldierUnitClass = soldierUnitClass;
        this.soldierAim = soldierAim;
        this.soldierSpeed = soldierSpeed;
        this.soldierWill = soldierWill;
        this.soldierDefense = soldierDefense;
    }

    @Ignore
    public SoldierUnitModel(String soldierName, String soldierAlias, String soldierNationality, String soldierUnitClass,
                            int soldierAim, int soldierSpeed, int soldierWill, int soldierDefense) {
        this.soldierName = soldierName;
        this.soldierAlias = soldierAlias;
        this.soldierNationality = soldierNationality;
        this.soldierUnitClass = soldierUnitClass;
        this.soldierAim = soldierAim;
        this.soldierSpeed = soldierSpeed;
        this.soldierWill = soldierWill;
        this.soldierDefense = soldierDefense;
    }

    public int getSoldierId() {
        return soldierId;
    }

    public String getSoldierName() {
        return soldierName;
    }

    public String getSoldierAlias() {
        return soldierAlias;
    }

    public String getSoldierNationality() {
        return soldierNationality;
    }

    public String getSoldierUnitClass() {
        return soldierUnitClass;
    }

    public int getSoldierAim() {
        return soldierAim;
    }

    public int getSoldierSpeed() {
        return soldierSpeed;
    }

    public int getSoldierWill() {
        return soldierWill;
    }

    public int getSoldierDefense() {
        return soldierDefense;
    }

    @Override
    public String toString() {
        return "SoldierUnitModel{" +
                "soldierId=" + soldierId +
                ", soldierName='" + soldierName + '\'' +
                ", soldierAlias='" + soldierAlias + '\'' +
                ", soldierNationality='" + soldierNationality + '\'' +
                ", soldierUnitClass='" + soldierUnitClass + '\'' +
                ", soldierAim='" + soldierAim + '\'' +
                ", soldierSpeed='" + soldierSpeed + '\'' +
                ", soldierWill='" + soldierWill + '\'' +
                ", soldierDefense=" + soldierDefense +
                '}';
    }

}
