package com.example.iot_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "userDatabase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table userdetails(name TEXT primary key, password TEXT)");
        db.execSQL("create Table userdevices(devicename TEXT primary key, username TEXT, ipaddress TEXT, area TEXT, status TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists userdetails");
    }

    public Boolean insertUserData(String name, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("password", password);
        long result =db.insert("userdetails",null, contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    public Boolean checkLogin(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select password from userdetails where name = ?", new String[]{username});
        cursor.moveToFirst();
        if (cursor != null) {
            do {
                for (int i = 0; i < cursor.getColumnCount(); i++) {

                    Log.e("FROM DATABASE:", "" + cursor.getString(i));
                    if(cursor.getString(i).equals(password)){
                        return true;
                    }
                }
            }while (cursor.moveToNext());
        }
        return false;
        /*if(cursor.getCount()>0){

            String dbPassword = cursor.getString(0);
            if(dbPassword.equals(password)){
                return true;
            }
            else
                return false;
        }
        else
            return false;*/
    }
    public Boolean checkDeviceUniqueness(String username, String deviceName){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from userdevices where username = ? and devicename = ?", new String[]{username, deviceName});
        if(cursor.getCount()>0){
            return false;
        }
        else
            return true;
    }
    public Boolean addDevice(String username, String deviceName, String ipAddress, String area, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("ipaddress", ipAddress);
        contentValues.put("area", area);
        contentValues.put("status", status);
        contentValues.put("devicename", deviceName);
        long result =db.insert("userdevices",null, contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }

    public Cursor getRegisteredDevices(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from userdevices where username = ?", new String[]{username});
        if(cursor.getCount()==0){
            return null;
        }
        else
            return cursor;
    }


}
