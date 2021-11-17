package com.example.iot_project;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "devices")
public class DeviceEntity {
    @PrimaryKey
    public long devlistID;

    @ColumnInfo(name = "ip")
    public String ip;

    @ColumnInfo(name = "area")
    public String area;

    @ColumnInfo(name = "status")
    public boolean status;

    @ColumnInfo(name = "devType")
    public String type;


    public long getDevlistID() {
        return devlistID;
    }

    public void setDevlistID(long devlistID) {
        this.devlistID = devlistID;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
