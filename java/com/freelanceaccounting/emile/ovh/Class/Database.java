package com.freelanceaccounting.emile.ovh.Class;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
     * Database management class.
     *
     * @author Emile Z.
     */

public class Database extends SQLiteOpenHelper {

    private Context context;

    Date currentUtilDate = new Date();

    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public Database(Context context){
        super(context, "freelanceaccounting.db", null, 1);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db){
        String sqlBank="CREATE TABLE bank(_id INTEGER PRIMARY KEY AUTOINCREMENT, SIREN VARCHAR UNIQUE, turnover_excluding_tax VARCHAR, bic1_excluding_tax VARCHAR,  bic2_excluding_tax VARCHAR, bnc_excluding_tax VARCHAR, treasury VARCHAR)";
        db.execSQL(sqlBank);
        String sqlBusiness="CREATE TABLE business(_id INTEGER PRIMARY KEY AUTOINCREMENT, SIREN VARCHAR, company_name VARCHAR, trade_name VARCHAR, SIRET VARCHAR,  vat_number VARCHAR, country VARCHAR, address VARCHAR, address_supplement VARCHAR, postal_code VARCHAR, city VARCHAR, state VARCHAR, description TEXT, date TIMESTAMP)";
        db.execSQL(sqlBusiness);
        String sqlCharge="CREATE TABLE charge(_id INTEGER PRIMARY KEY AUTOINCREMENT, SIREN VARCHAR, name VARCHAR, category VARCHAR, price VARCHAR, state VARCHAR, description TEXT, date TIMESTAMP)";
        db.execSQL(sqlCharge);
        String sqlClient="CREATE TABLE client(_id INTEGER PRIMARY KEY AUTOINCREMENT, SIREN VARCHAR, name VARCHAR, email VARCHAR, phone VARCHAR, category VARCHAR, langue VARCHAR, country VARCHAR, address VARCHAR, address_supplement VARCHAR, postal_code VARCHAR, city VARCHAR, state VARCHAR, description TEXT, date TIMESTAMP)";
        db.execSQL(sqlClient);
        String sqlCurrency="CREATE TABLE currency(_id INTEGER PRIMARY KEY AUTOINCREMENT, SIREN VARCHAR, customer_name VARCHAR, service_name VARCHAR, category VARCHAR, start_date VARCHAR, end_date VARCHAR, hours_days VARCHAR, number_days VARCHAR, costhour VARCHAR, price_ht VARCHAR, state VARCHAR, description TEXT, date TIMESTAMP)";
        db.execSQL(sqlCurrency);
        String sqlService="CREATE TABLE service(_id INTEGER PRIMARY KEY AUTOINCREMENT, SIREN VARCHAR, name VARCHAR, category VARCHAR, costhour VARCHAR, state VARCHAR, description TEXT, date TIMESTAMP)";
        db.execSQL(sqlService);
        String sqlSetting="CREATE TABLE setting(_id INTEGER PRIMARY KEY AUTOINCREMENT, setting_name VARCHAR, setting_set VARCHAR)";
        db.execSQL(sqlSetting);
        String sqlUser="CREATE TABLE user(_id INTEGER PRIMARY KEY AUTOINCREMENT, status VARCHAR, type VARCHAR, SIREN VARCHAR UNIQUE, SIRET VARCHAR, date_creation VARCHAR, taxation VARCHAR,  first_name VARCHAR, last_name VARCHAR, identifier VARCHAR, email VARCHAR, email_verification VARCHAR, phone VARCHAR, user_key VARCHAR, recovery_key VARCHAR, date TIMESTAMP)";
        db.execSQL(sqlUser);
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS bank");
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS business");
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS charge");
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS client");
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS currency");
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS service");
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS setting");
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }

    public Cursor readData(){
        String sqlUser = "SELECT * FROM User";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(sqlUser, null);
        }
        return cursor;
    }

}
