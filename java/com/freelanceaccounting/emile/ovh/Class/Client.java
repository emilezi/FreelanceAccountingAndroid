package com.freelanceaccounting.emile.ovh.Class;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
     * Client management class.
     *
     * @author Emile Z.
     */

public class Client extends SQLiteOpenHelper{

    private Context context;

    Date currentUtilDate = new Date();

    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public Client(Context context){
        super(context, "freelanceaccounting.db", null, 1);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db){
        String sqlClient="CREATE TABLE client(_id INTEGER PRIMARY KEY AUTOINCREMENT, SIREN VARCHAR, name VARCHAR, email VARCHAR, phone VARCHAR, category VARCHAR, langue VARCHAR, country VARCHAR, address VARCHAR, address_supplement VARCHAR, postal_code VARCHAR, city VARCHAR, state VARCHAR, description TEXT, date TIMESTAMP)";
        db.execSQL(sqlClient);
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS client");
        onCreate(db);
    }

    void newClient(String SIREN, String name, String email, String phone, String category, String langue, String country, String address, String address_supplement, String postal_code, String city, String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("SIREN", SIREN);
        cv.put("name", name);
        cv.put("email", email);
        cv.put("phone", phone);
        cv.put("category", category);
        cv.put("langue", langue);
        cv.put("country", country);
        cv.put("address", address);
        cv.put("address_supplement", address_supplement);
        cv.put("postal_code", postal_code);
        cv.put("city", city);
        cv.put("state", "state");
        cv.put("description", description);
        cv.put("date", currentUtilDate.getTime());
        db.insert("client", null, cv);

    }

}
