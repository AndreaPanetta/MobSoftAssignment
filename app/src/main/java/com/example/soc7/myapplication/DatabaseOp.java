/**
 ************************************************************************************************
 * Name: Andrea Panetta
 * Student No: C13312461
 * Description:
 */
package com.example.soc7.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;
import android.util.Log;


public class DatabaseOp extends SQLiteOpenHelper
{
    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE "+ TData.TInfo.TABLE_NAME+"("+ TData.TInfo.USER_NAME+" TEXT,"+ TData.TInfo.USER_PASS+" TEXT,"+TData.TInfo.F_NAME+" TEXT,"+TData.TInfo.L_NAME+" TEXT,"+TData.TInfo.EMAIL+" TEXT,"+TData.TInfo.AGE+" TEXT );";

    public DatabaseOp(Context context)
   {
       super(context, TData.TInfo.DATABASE_NAME, null, database_version);
       Log.d("Database Operations", "Database created");
   }

    @Override
    public void onCreate(SQLiteDatabase sdb)
    {
        sdb.execSQL(CREATE_QUERY);
        Log.d("Database Operations", "Table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertInformation(DatabaseOp dop, String user, String pass, String f_name, String l_name, String email, String age)
    {
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TData.TInfo.USER_NAME, user);
        cv.put(TData.TInfo.USER_PASS, pass);
        cv.put(TData.TInfo.F_NAME, f_name);
        cv.put(TData.TInfo.L_NAME, l_name);
        cv.put(TData.TInfo.EMAIL, email);
        cv.put(TData.TInfo.AGE, age);
        long x = SQ.insert(TData.TInfo.TABLE_NAME, null, cv);
        Log.d("Database Operations", "One row inserted");

    }

    public Cursor getInformation(DatabaseOp dop)
    {
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] coloumns = {TData.TInfo.USER_NAME, TData.TInfo.USER_PASS};
        Cursor CR = SQ.query(TData.TInfo.TABLE_NAME, coloumns ,null, null,null, null, null);
        return CR;
    }
}
