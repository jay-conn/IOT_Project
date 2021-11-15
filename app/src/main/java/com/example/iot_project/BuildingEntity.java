package com.example.iot_project;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class BuildingEntity {
    @PrimaryKey(autoGenerate = true)
    public int buildingId;

    @ColumnInfo(name = "devName")
    public String devName;

    @ColumnInfo(name = "ip")
    public String ip;

    @ColumnInfo(name = "area")
    public String area;

    @ColumnInfo(name = "status")
    public boolean status;

    @ColumnInfo(name = "state")
    public boolean state;
}