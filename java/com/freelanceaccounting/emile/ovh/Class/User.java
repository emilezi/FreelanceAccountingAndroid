package com.freelanceaccounting.emile.ovh.Class;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.Date;
import java.text.SimpleDateFormat;

public class User extends SQLiteOpenHelper {

    private Context context;

    Date currentUtilDate = new Date();

    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public User(Context context){
        super(context, "freelanceaccounting.db", null, 1);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db){
        String sqlUser="CREATE TABLE user(_id INTEGER PRIMARY KEY AUTOINCREMENT, status VARCHAR, type VARCHAR, SIREN VARCHAR UNIQUE, SIRET VARCHAR,  first_name VARCHAR, last_name VARCHAR, identifier VARCHAR, email VARCHAR, phone VARCHAR, password VARCHAR, user_key VARCHAR, recovery_key VARCHAR, date TIMESTAMP)";
        db.execSQL(sqlUser);
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }

    void firstUser(String SIREN, String SIRET, String first_name, String last_name, String identifier, String email, String phone, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("status", "active");
        cv.put("type", "admin");
        cv.put("SIREN", SIREN);
        cv.put("SIRET", SIRET);
        cv.put("first_name", first_name);
        cv.put("last_name", last_name);
        cv.put("identifier", identifier);
        cv.put("email", email);
        cv.put("phone", phone);
        cv.put("password", password);
        /*cv.put("user_key", user_key);*/
        /*cv.put("recovery_key", recovery_key);*/
        cv.put("date", currentUtilDate.getTime());
        long result = db.insert("user", null, cv);
        if(result == -1){
            Toast.makeText(context, "Erreur", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Profil créé avec succès", Toast.LENGTH_SHORT).show();
        }

    }

    void newUser(String SIREN, String SIRET, String first_name, String last_name, String identifier, String email, String phone, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("status", "active");
        cv.put("type", "user");
        cv.put("SIREN", SIREN);
        cv.put("SIRET", SIRET);
        cv.put("first_name", first_name);
        cv.put("last_name", last_name);
        cv.put("identifier", identifier);
        cv.put("email", email);
        cv.put("phone", phone);
        cv.put("password", password);
        /*cv.put("user_key", user_key);*/
        /*cv.put("recovery_key", recovery_key);*/
        cv.put("date", currentUtilDate.getTime());
        long result = db.insert("user", null, cv);
        if(result == -1){
            Toast.makeText(context, "Erreur", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Profil créé avec succès", Toast.LENGTH_SHORT).show();
        }

    }

}
