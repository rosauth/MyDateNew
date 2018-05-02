package com.android.mydate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rosa on 4/30/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context){
        super(context, DBContract.DB_NAME, null, DBContract.DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableUser = "CREATE TABLE " + DBContract.UserEntry.TABLE_USER + " ( " +
                DBContract.UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DBContract.UserEntry.COL_NAME + " TEXT NOT NULL, " +
                DBContract.UserEntry.COL_EMAIL + " TEXT NOT NULL, " +
                DBContract.UserEntry.COL_ADDR + " TEXT NOT NULL, " +
                DBContract.UserEntry.COL_NUM + " INTEGER NOT NULL, " +
                DBContract.UserEntry.COL_PWD + " TEXT NOT NULL);";

        String createTableChat = "CREATE TABLE " + DBContract.UserEntry.TABLE_CHAT + " ( " +
                DBContract.UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                // Foreign key
                DBContract.UserEntry.COL_SEN + " INTEGER NOT NULL, " +
                " FOREIGN KEY (" + DBContract.UserEntry.COL_SEN + ") REFERENCES " +
                DBContract.UserEntry.TABLE_USER  + " (" + DBContract.UserEntry._ID + ")" +

                // Foreign key
                DBContract.UserEntry.COL_REC + " INTEGER NOT NULL, " +
                " FOREIGN KEY (" + DBContract.UserEntry.COL_REC + ") REFERENCES " +
                DBContract.UserEntry.TABLE_USER  + " (" + DBContract.UserEntry._ID + ")" +

                DBContract.UserEntry.COL_CONT + " TEXT NOT NULL, " +
                DBContract.UserEntry.COL_CTIME + " TIME NOT NULL);";

        String createTablePoke = "CREATE TABLE " + DBContract.UserEntry.TABLE_POKE + " ( " +
                DBContract.UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT" +

                // Foreign key
                DBContract.UserEntry.COL_SPOKE + " INTEGER NOT NULL, " +
                " FOREIGN KEY (" + DBContract.UserEntry.COL_SPOKE + ") REFERENCES " +
                DBContract.UserEntry.TABLE_USER  + " (" + DBContract.UserEntry._ID + ")" +

                // Foreign key
                DBContract.UserEntry.COL_RPOKE + " INTEGER NOT NULL, " +
                " FOREIGN KEY (" + DBContract.UserEntry.COL_RPOKE + ") REFERENCES " +
                DBContract.UserEntry.TABLE_USER  + " (" + DBContract.UserEntry._ID + ")" +

                DBContract.UserEntry.COL_PTIME + " TIME NOT NULL);";

        sqLiteDatabase.execSQL(createTableUser);
        sqLiteDatabase.execSQL(createTableChat);
        sqLiteDatabase.execSQL(createTablePoke);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DBContract.UserEntry.TABLE_USER);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DBContract.UserEntry.TABLE_CHAT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DBContract.UserEntry.TABLE_POKE);
        onCreate(sqLiteDatabase);
    }
}
