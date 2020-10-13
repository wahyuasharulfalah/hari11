package com.example.myapplication.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "digitalent.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_SQLITE = "sqlite";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ADDRESS = "address";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_SQLITE
                + "("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_NAME+" TEXT NOT NULL,"+COLUMN_ADDRESS+" TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS "+ TABLE_SQLITE;
        db.execSQL(sql);
        onCreate(db);
    }
    public void insert(String name, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO "+TABLE_SQLITE+" (name, address) "+"VALUES ('"+name+"','"+address+"')");
        db.close();
    }
    public void update(int id, String name, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE "+TABLE_SQLITE+" SET "
                +COLUMN_NAME+"='"+name+"' , "+COLUMN_ADDRESS+"='"+address+"' WHERE "+COLUMN_ID+"='"+id+"'");
        db.close();
    }
    public void delete (int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+TABLE_SQLITE+" WHERE "+COLUMN_ID+ "='"+id+"'");
        db.close();
    }
    public ArrayList<HashMap<String, String>> getAllData(){
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT * FROM " + TABLE_SQLITE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put(COLUMN_ID, cursor.getString(0));
                map.put(COLUMN_NAME,cursor.getString(1));
                map.put(COLUMN_ADDRESS, cursor.getString(2));
                wordList.add(map);
            } while (cursor.moveToNext());
        }
        Log.d("TAG","sqlite"+wordList);
        db.close();
        return wordList;
    }
}

