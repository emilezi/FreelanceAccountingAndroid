package com.freelanceaccounting.emile.ovh.Class;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;

public class Helper extends SQLiteOpenHelper {

    static final String DB_NAME="freelancemanager.db";
    static final int DB_VERSION=1;

    public Helper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlBank="CREATE TABLE bank(_id INTEGER PRIMARY KEY, SIREN VARCHAR, tbic1_excluding_tax VARCHAR, bic2_excluding_tax VARCHAR, bnc_excluding_tax VARCHAR, treasury VARCHAR)";
        sqLiteDatabase.execSQL(sqlBank);
        String sqlBusiness="CREATE TABLE business(_id INTEGER PRIMARY KEY, SIREN VARCHAR UNIQUE, company_name VARCHAR, trade_name VARCHAR, SIRET VARCHAR, vat_number VARCHAR, vat_number VARCHAR, langue VARCHAR, country VARCHAR, address VARCHAR, address_supplement VARCHAR, postal_code VARCHAR, city VARCHAR, state VARCHAR, description TEXT, date TIMESTAMP)";
        sqLiteDatabase.execSQL(sqlBusiness);
        String sqlCharge="CREATE TABLE charge(_id INTEGER PRIMARY KEY, SIREN VARCHAR, name VARCHAR, category VARCHAR, price VARCHAR, state VARCHAR, description TEXT, date TIMESTAMP)";
        sqLiteDatabase.execSQL(sqlCharge);
        String sqlClient="CREATE TABLE client(_id INTEGER PRIMARY KEY, SIREN VARCHAR, name VARCHAR, email VARCHAR, phone VARCHAR, category VARCHAR, langue VARCHAR, country VARCHAR, address VARCHAR, address_supplement VARCHAR, postal_code VARCHAR, city VARCHAR, state VARCHAR, description TEXT, date TIMESTAMP)";
        sqLiteDatabase.execSQL(sqlClient);
        String sqlCurrency="CREATE TABLE currency(_id INTEGER PRIMARY KEY, SIREN VARCHAR, customer_name VARCHAR, service_name VARCHAR, start_date VARCHAR, end_date VARCHAR, hours_days VARCHAR, number_days VARCHAR, state VARCHAR, description TEXT, date TIMESTAMP)";
        sqLiteDatabase.execSQL(sqlCurrency);
        String sqlService="CREATE TABLE service(_id INTEGER PRIMARY KEY, SIREN VARCHAR, name VARCHAR, category VARCHAR, costhour VARCHAR, state VARCHAR, description TEXT, date TIMESTAMP)";
        sqLiteDatabase.execSQL(sqlService);
        String sqlSetting="CREATE TABLE setting(_id INTEGER PRIMARY KEY, setting_name VARCHAR, setting_set VARCHAR)";
        sqLiteDatabase.execSQL(sqlSetting);
        String sqlUser="CREATE TABLE user(_id INTEGER PRIMARY KEY, status VARCHAR, type VARCHAR, SIREN VARCHAR UNIQUE, SIRET VARCHAR,  first_name VARCHAR, last_name VARCHAR, identifier VARCHAR, email VARCHAR, phone VARCHAR, password VARCHAR, user_key VARCHAR, recovery_key VARCHAR, date TIMESTAMP)";
        sqLiteDatabase.execSQL(sqlUser);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void callCreateDatabase() {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Log.i("BT","Création de la base de données réussie");
    }

}
