package com.example.uts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "latuas", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createquery = "CREATE TABLE IF NOT EXISTS person" + "(name text, age int);";
        db.execSQL(createquery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertData(String name, int age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("age", age);
        long status = db.insert("person", null, cv);
        if(status == -1) return false;
        return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String readquery = "SELECT * FROM person";
        Cursor c = db.rawQuery(readquery, null);
        return c;
    }
}
