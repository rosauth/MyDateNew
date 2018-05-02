package com.android.mydate;

import android.provider.BaseColumns;

/**
 * Created by rosa on 4/30/2018.
 */

public class DBContract {
    public static final String DB_NAME = "com.android.mydate.db";
    public static final int DB_VERSION = 1;

    public class UserEntry implements BaseColumns{
        // User Table
        public static final String TABLE_USER = "users";
        public static final String COL_NAME = "name";
        public static final String COL_ADDR = "address";
        public static final String COL_EMAIL = "email";
        public static final String COL_NUM = "mobile_number";
        public static final String COL_PWD = "password";

        //Chat Table
        public static final String TABLE_CHAT = "chats";
        public static final String COL_SEN = "id_sender";
        public static final String COL_REC = "id_receiver";
        public static final String COL_CONT = "chat_content";
        public static final String COL_CTIME = "chat_time";

        //Poke Table
        public static final String TABLE_POKE = "poke";
        public static final String COL_SPOKE = "id_poke_sender";
        public static final String COL_RPOKE = "id_poke_receiver";
        public static final String COL_PTIME = "poke_time";

    }
}
