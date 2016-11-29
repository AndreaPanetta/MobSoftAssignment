package com.example.soc7.myapplication;

import android.provider.BaseColumns;

/**
 * Created by AndreaPanetta on 29/11/2016.
 */

public class TData {

    public TData()
    {

    }

    public static abstract class TInfo implements BaseColumns
    {
        public static final String USER_NAME = "user_name";
        public static final String USER_PASS = "user_pass";
        public static final String F_NAME = "f_name";
        public static final String L_NAME = "l_name";
        public static final String EMAIL = "email";
        public static final String AGE = "age";
        public static final String DATABASE_NAME = "user_info";
        public static final String TABLE_NAME = "reg_info";
    }
}
