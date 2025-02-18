package com.freelanceaccounting.emile.ovh.Class;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
     * Charge management class.
     *
     * @author Emile Z.
     */

public class Charge extends SQLiteOpenHelper{

    private Context context;

    Date currentUtilDate = new Date();

    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public Charge(Context context){
        super(context, "freelanceaccounting.db", null, 1);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db){
        String sqlCharge="CREATE TABLE charge(_id INTEGER PRIMARY KEY AUTOINCREMENT, SIREN VARCHAR, name VARCHAR, category VARCHAR, price VARCHAR, state VARCHAR, description TEXT, date TIMESTAMP)";
        db.execSQL(sqlCharge);
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS charge");
        onCreate(db);
    }

    void newCharge(String SIREN, String name, String category, String price, String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("SIREN", SIREN);
        cv.put("name", name);
        cv.put("category", category);
        cv.put("price", price);
        cv.put("state", "state");
        cv.put("description", description);
        cv.put("date", currentUtilDate.getTime());
        db.insert("charge", null, cv);

    }

}