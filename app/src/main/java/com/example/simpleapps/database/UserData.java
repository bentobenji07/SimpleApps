package com.example.simpleapps.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.simpleapps.Config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



public class UserData {

    private static final String TABLE                     ="USER";
    private static final String _ID                       ="_ID";
    private static final String EMAIL                     ="EMAIL";
    private static final String NAME                      ="NAME";



    public static final String CREATE_TABLE =
            " CREATE TABLE "+TABLE+" ("
                    +_ID+" INTEGER PRIMARY KEY, "
                    +EMAIL+" TEXT, "
                    +NAME+" TEXT); ";


    private final Context context;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase sqLiteDatabase;

    public UserData(Context context) {
        this.context = context;
    }

    private UserData open() throws SQLException {
        Config config = new Config(context);
        databaseHelper = new DatabaseHelper(context, config.getDatabaseName(), config.getDatabaseVersion());
        return this;
    }

    private void close() {
        if (sqLiteDatabase != null && sqLiteDatabase.isOpen())
            sqLiteDatabase.close();
    }

    public UserMetaData save(UserMetaData metaData){

        try {

            open();
            sqLiteDatabase = databaseHelper.getWritableDatabase();

            ContentValues v = new ContentValues();
            v.put(NAME, metaData.getName());
            v.put(EMAIL, metaData.getEmail());
            if (metaData.getSqliteId() == null) {
                Long id = sqLiteDatabase.insert(TABLE, null, v);
                metaData.setSqliteId(id.intValue());
            } else {
                sqLiteDatabase.update(TABLE, v, _ID + "=?", new String[]{String.valueOf(metaData.getSqliteId())});
            }

            close();
            return metaData;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }



    }


    public int count() {
        String q = "SELECT * FROM "+TABLE+" WHERE 1=1 ";

        open();
        sqLiteDatabase = databaseHelper.getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery(q, null);
        int count = c.getCount();
        c.close();
        close();
        return count;
    }


}

