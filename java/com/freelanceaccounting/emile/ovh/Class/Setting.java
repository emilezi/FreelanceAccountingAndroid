package com.freelanceaccounting.emile.ovh.Class;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
     * Setting management class.
     *
     * @author Emile Z.
     */

public class Setting extends SQLiteOpenHelper{

    private Context context;

    public Setting(Context context){
        super(context, "freelanceaccounting.db", null, 1);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db){
        String sqlSetting="CREATE TABLE setting(_id INTEGER PRIMARY KEY AUTOINCREMENT, setting_name VARCHAR, setting_set VARCHAR)";
        db.execSQL(sqlSetting);
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS setting");
        onCreate(db);
    }

    void addSetting(String setting_name, String setting_set){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("setting_name", setting_name);
        cv.put("setting_set", setting_set);
        db.insert("setting", null, cv);

    }

}
