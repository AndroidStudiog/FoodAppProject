package com.example.foodappproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBContact extends SQLiteOpenHelper {
    public DBContact(@Nullable Context context) {
        super(context,"DBContacts.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Contact(conId integer primary key,conName Text,conEmail Text,conPhoneNo Text,Message Text)");
    }//

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Contact");
    }

    public boolean insertContact(String con_name,String con_email,String con_phone,String message){
        SQLiteDatabase conDb=this.getWritableDatabase();
        ContentValues values3=new ContentValues();
        values3.put("conName",con_name);
        values3.put("conEmail",con_email);
        values3.put("conPhoneNo",con_phone);
        values3.put("Message",message);
        Long con=conDb.insert("Contact",null,values3);
        if (con==-1){
            return false;
        }
        else {
            return true;
        }
    }
}