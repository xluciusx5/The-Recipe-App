package com.android.recipeapp.models;


import android.provider.BaseColumns;

public final class TableContainer {

    private TableContainer() {}

    public static class User implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_PASSWORD = "password";

    }
}