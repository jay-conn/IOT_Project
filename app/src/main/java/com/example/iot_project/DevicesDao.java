package com.example.iot_project;

import androidx.room.Insert;
import androidx.room.Query;

public interface DevicesDao {
    @Insert
    void addDevice(DeviceEntity deviceEntity);

    //showing devices of a single type
    @Query("SELECT * from devices where devType=(:devType)")
    DeviceEntity selectDevice(String devType);

    //Changing single status
    @Query("UPDATE devices SET status=(:status) where devlistID=(:devListID)")
    DeviceEntity changeStatus(Boolean status, String devListID);

    //Changing devType status
    @Query("UPDATE devices SET status=(:status) where devType=(:devType)")
    DeviceEntity changeStatusType(Boolean status, String devType);

    //Changing global status
    @Query("UPDATE devices SET status=(:status)")
    DeviceEntity changeStatusGlobal(Boolean status);

    //Delete device
    //Changing devType status
    @Query("DELETE FROM devices where devListID=(:devListID)")
    DeviceEntity deleteDevice(String devListID);

}

