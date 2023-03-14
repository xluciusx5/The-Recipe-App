package com.android.recipeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.android.recipeapp.models.TableContainer;
import com.android.recipeapp.models.User;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper
{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "recipes.db";

    private static final String SQL_CREATE_USER =
            "CREATE TABLE " + TableContainer.User.TABLE_NAME + " (" +
                    TableContainer.User._ID + " INTEGER PRIMARY KEY," +
                    TableContainer.User.COLUMN_NAME_USERNAME + " TEXT," +
                    TableContainer.User.COLUMN_NAME_PASSWORD + " TEXT)";

    private static final String SQL_DELETE_USER =
            "DROP TABLE IF EXISTS " + TableContainer.User.TABLE_NAME;

    public DbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_USER);

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(SQL_DELETE_USER);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        onUpgrade(db, oldVersion, newVersion);
    }

    public long addUser(DbHelper dbHelper, User user)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TableContainer.User.COLUMN_NAME_USERNAME, user.username);
        values.put(TableContainer.User.COLUMN_NAME_PASSWORD, user.password);

        return db.insert(TableContainer.User.TABLE_NAME, null, values);
    }

    public List<User> getAllUsers(DbHelper dbHelper)
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query
                (
                TableContainer.User.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        List<User> users = new ArrayList<>();
        while(cursor.moveToNext())
        {
            String username = cursor.getString(
                    cursor.getColumnIndexOrThrow(TableContainer.User.COLUMN_NAME_USERNAME));
            String password = cursor.getString(
                    cursor.getColumnIndexOrThrow(TableContainer.User.COLUMN_NAME_PASSWORD));
            users.add(new User(username,password));
        }
        cursor.close();

        return users;
    }
}