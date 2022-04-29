package com.example.foodappproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context,"Registration",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB1) {
        DB1.execSQL("create table UserTable(id integer primary key,Name Text,Email Text,Password Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB2, int i, int i1) {
        DB2.execSQL("drop table if exists UserTable");
    }

    public boolean insertUserData(String name,String email,String password){
        SQLiteDatabase DB3=getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put("Name",name);
        values.put("Email",email);
        values.put("Password",password);
        Long query=DB3.insert("UserTable",null,values);
        if (query==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean checkEmail(String email){
        SQLiteDatabase DB3=getWritableDatabase();
        Cursor cursor=DB3.rawQuery("select * from UserTable where Email=?",new String[]{email});
        if (cursor.getCount()>1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkEmailAndPassword(String email,String password){
        SQLiteDatabase DB3=getWritableDatabase();
        Cursor cursor=DB3.rawQuery("select * from UserTable where Email=? and Password=?",new String[]{email,password});
        if (cursor.getCount()>1){
            return true;
        }
        else{
            return false;
        }
    }
}