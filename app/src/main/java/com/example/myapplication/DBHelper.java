package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "DB.db";
    private static final int SCHEMA = 1;
    static final String TABLE_SLOVAR = "Slovar";
    static final String TABLE_SLOVAR1 = "WordsSlovar";
    static final String USER = "User";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ID_SLOVAR = "id_slovar";
    public static final String COLUMN_IDF = "idf";
    public static final String COLUMN_SLOVO = "word";
    public static final String COLUMN_SLOVO_TRANS = "translate";
    public static final String COLUMN_NAME = "name";


    public DBHelper(Context context) {
        super(context,DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Slovar (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_IDF + " TEXT," + COLUMN_NAME + " TEXT);");
        db.execSQL("CREATE TABLE WordsSlovar (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_IDF + " TEXT," + COLUMN_ID_SLOVAR + " INTEGER,"+COLUMN_SLOVO+" TEXT," + COLUMN_SLOVO_TRANS +" TEXT);");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int Oldversion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SLOVAR);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SLOVAR1);
        db.execSQL("DROP TABLE IF EXISTS "+USER);
        onCreate(db);
    }




}
