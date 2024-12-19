package com.freelanceaccounting.emile.ovh.Class;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Service extends SQLiteOpenHelper{

    private Context context;

    Date currentUtilDate = new Date();

    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public Service(Context context){
        super(context, "freelanceaccounting.db", null, 1);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db){
        String sqlService="CREATE TABLE service(_id INTEGER PRIMARY KEY AUTOINCREMENT, SIREN VARCHAR, name VARCHAR, category VARCHAR, costhour VARCHAR, state VARCHAR, description TEXT, date TIMESTAMP)";
        db.execSQL(sqlService);
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS service");
        onCreate(db);
    }


    void newService(String SIREN, String name, String category, String costhour, String description){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("SIREN", SIREN);
        cv.put("name", name);
        cv.put("category", category);
        cv.put("costhour", costhour);
        cv.put("state", "state");
        cv.put("description", description);
        cv.put("date", currentUtilDate.getTime());
        db.insert("service", null, cv);

    }

}
