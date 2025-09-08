package com.freelanceaccounting.emile.ovh.Class;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
     * Bank management class.
     *
     * @author Emile Z.
     */

public class Bank extends SQLiteOpenHelper{

    private Context context;

    public Bank(Context context){
        super(context, "freelanceaccounting.db", null, 1);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db){
        String sqlBank="CREATE TABLE bank(_id INTEGER PRIMARY KEY AUTOINCREMENT, SIREN VARCHAR UNIQUE, turnover_excluding_tax VARCHAR, bic1_excluding_tax VARCHAR,  bic2_excluding_tax VARCHAR, bnc_excluding_tax VARCHAR, treasury VARCHAR)";
        db.execSQL(sqlBank);
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS bank");
        onCreate(db);
    }

    public void newBank(String SIREN){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("SIREN", SIREN);
        cv.put("turnover_excluding_tax", "0");
        cv.put("bic1_excluding_tax", "0");
        cv.put("bic2_excluding_tax", "0");
        cv.put("bnc_excluding_tax", "0");
        cv.put("treasury", "0");
        db.insert("bank", null, cv);

    }

}
