package com.freelanceaccounting.emile.ovh.Class;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Currency extends SQLiteOpenHelper{

    private Context context;

    Date currentUtilDate = new Date();

    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public Currency(Context context){
        super(context, "freelanceaccounting.db", null, 1);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db){
        String sqlCurrency="CREATE TABLE currency(_id INTEGER PRIMARY KEY AUTOINCREMENT, SIREN VARCHAR, customer_name VARCHAR, service_name VARCHAR, start_date VARCHAR, end_date VARCHAR, hours_days VARCHAR, number_days VARCHAR, state VARCHAR, description TEXT, date TIMESTAMP)";
        db.execSQL(sqlCurrency);
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS currency");
        onCreate(db);
    }

    void newCurrency(String SIREN, String customer_name, String service_name, String start_date, String end_date, String hours_days, String number_days, String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("SIREN", SIREN);
        cv.put("customer_name", customer_name);
        cv.put("service_name", service_name);
        cv.put("start_date", start_date);
        cv.put("end_date", end_date);
        cv.put("hours_days", hours_days);
        cv.put("number_days", number_days);
        cv.put("state", "state");
        cv.put("description", description);
        cv.put("date", currentUtilDate.getTime());
        db.insert("currency", null, cv);

    }

}
