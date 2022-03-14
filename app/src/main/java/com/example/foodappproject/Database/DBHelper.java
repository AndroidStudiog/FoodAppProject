package com.example.foodappproject.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context,"Registration",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB1) {
        DB1.execSQL("create table UserTable(id integer primary key,Name Text,Phone Text,Email Text,Password Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB2, int i, int i1) {
        DB2.execSQL("drop table if exists UserTable");
    }
}
