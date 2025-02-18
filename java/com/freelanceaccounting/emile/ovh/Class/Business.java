package com.freelanceaccounting.emile.ovh.Class;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
     * Business management class.
     *
     * @author Emile Z.
     */

public class Business extends SQLiteOpenHelper{

    private Context context;

    Date currentUtilDate = new Date();

    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public Business(Context context){
        super(context, "freelanceaccounting.db", null, 1);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db){
        String sqlBusiness="CREATE TABLE business(_id INTEGER PRIMARY KEY AUTOINCREMENT, SIREN VARCHAR, company_name VARCHAR, trade_name VARCHAR, SIRET VARCHAR,  vat_number VARCHAR, country VARCHAR, address VARCHAR, address_supplement VARCHAR, postal_code VARCHAR, city VARCHAR, state VARCHAR, description TEXT, date TIMESTAMP)";
        db.execSQL(sqlBusiness);
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS business");
        onCreate(db);
    }

    void newBusiness(String SIREN, String company_name, String trade_name, String SIRET, String vat_number, String langue, String country, String address, String address_supplement, String postal_code, String city, String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("SIREN", SIREN);
        cv.put("company_name", company_name);
        cv.put("trade_name", trade_name);
        cv.put("SIRET", SIRET);
        cv.put("vat_number", vat_number);
        cv.put("country", country);
        cv.put("address", address);
        cv.put("address_supplement", address_supplement);
        cv.put("postal_code", postal_code);
        cv.put("city", city);
        cv.put("state", "state");
        cv.put("description", description);
        cv.put("date", currentUtilDate.getTime());
        db.insert("business", null, cv);

    }

}
