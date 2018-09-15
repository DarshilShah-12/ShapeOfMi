package com.example.rienwave.exerciseanalyzer.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "exercise_analyser.db";
    public static final String TABLE_NAME = "users_table";
    public static final String COL_1 = "USER_ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "USERNAME";
    public static final String COL_4 = "PASSWORD";

    public static final String DATA_TABLE = "data_table";
    public static final String DATA_1 = "DATA_ID";
    public static final String DATA_2 = "USER_ID";
    public static final String DATA_3 = "TYPE";
    public static final String DATA_4 = "COUNTER";
    public static final String DATA_5 = "TIME_ID";
    public static final String DATA_6 = "CREATED_AT";


    public static final String EXACT_TIME_TABLE = "time_table";
    public static final String TIME_1 = "TIME_ID";
    public static final String TIME_2 = "DATA_ID";
    public static final String TIME_3 = "TIME";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(USER_ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,USERNAME TEXT,PASSWORD TEXT)");
        db.execSQL("CREATE TABLE " + DATA_TABLE + "(DATA_ID INTEGER PRIMARY KEY AUTOINCREMENT, USER_ID INTEGER, TYPE TEXT,COUNTER INTEGER, TIME_ID INTEGER, CREATED_AT DATETIME)");
        db.execSQL("CREATE TABLE " + EXACT_TIME_TABLE + "(TIME_ID INTEGER PRIMARY KEY AUTOINCREMENT, DATA_ID INTEGER, TIME DATETIME)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + DATA_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + EXACT_TIME_TABLE);
        onCreate(db);
    }

    public boolean insertUser(String name, String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, username);
        contentValues.put(COL_4, password);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertData(Integer user_id, String activity_type, Integer counter, Integer datetime_id, Date created_at) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DATA_2, user_id);
        contentValues.put(DATA_3, activity_type);
        contentValues.put(DATA_4, counter);
        contentValues.put(DATA_5, datetime_id);
        contentValues.put(DATA_6, String.valueOf(created_at));

        long result = db.insert(DATA_TABLE, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertDateTime(Integer data_id, Date date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TIME_2, data_id);
        contentValues.put(TIME_3, String.valueOf(date));

        long result = db.insert(EXACT_TIME_TABLE, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public static int[] getData() {
        int[] a = {1,2};
        return a;
    }

//    public static ArrayList<ArrayList<Integer>> getSomeData() {
//        ArrayList<Integer> inside_sample = new ArrayList<Integer>();
//        ArrayList<Integer> inside_sample_2 = new ArrayList<Integer>();
//        ArrayList<ArrayList<Integer>> outside_sample = new ArrayList<ArrayList<Integer>>();
//        inside_sample.add(1);
//        inside_sample.add(2);
//        inside_sample_2.add(3);
//        inside_sample_2.add(4);
//
//        outside_sample.add(inside_sample);
//        outside_sample.add(inside_sample_2);
//
//        return outside_sample;
//    }
}
