package com.example.rienwave.exerciseanalyzer;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(USER_ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,USERNAME TEXT,PASSWORD TEXT)");
        db.execSQL("CREATE TABLE " + DATA_TABLE + "(DATA_ID INTEGER PRIMARY KEY AUTOINCREMENT, USER_ID INTEGER, TYPE TEXT,COUNTER INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + DATA_TABLE);
        onCreate(db);
    }

    public boolean insertData(String name, String username, String password) {
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
}
