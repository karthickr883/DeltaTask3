package com.example.karthik.delta3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

/**
 * Created by karthik on 04-07-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String table_name = "characterData";
    private static final String database_name = "gotData";
    private static final String Col1 = "_id";
    private static final String Col2 = "Name";
    private static final String Col3 = "Dob";
    private static final String Col4 = "Gender";
    private static final String Col5 = "House";
    private static final String Col6 = "Culture";
    private static final String Col7 = "Books";


    public DatabaseHelper(Context context) {

        super(context, database_name, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + table_name + "( " + Col1 + " INTEGER PRIMARY KEY AUTOINCREMENT ," + Col2 + " VARCHAR(255) ," + Col3 + " INTEGER ," + Col4 + " VARCHAR(255)," + Col5 + " VARCHAR(255)," + Col6 + " VARCHAR(255)," + Col7 + " VARCHAR(255));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addData(String name, int dob, String gender, String house, String culture, String books) {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.d("Inside database",house);
        ContentValues contentValues = new ContentValues();
        if (culture == null)
            culture = "Not available";
        contentValues.put(Col2, name);
        contentValues.put(Col3, dob);
        contentValues.put(Col4, gender);
        contentValues.put(Col5, house);
        contentValues.put(Col6, culture);
        contentValues.put(Col7, books);
        db.insert(table_name, null, contentValues);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public Cursor getData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + table_name + " where " + Col2 + " =?", new String[]{name}, null);
        return cursor;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(" Select * from " + table_name + "", null);
        return cursor;
    }
}
