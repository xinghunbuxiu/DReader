package com.duokan.reader.common.download;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class b extends SQLiteOpenHelper {
    public b(Context context) {
        super(context, "Downloads.db", null, 2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL(String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", new Object[]{"tasks", "task_id", "task_class", "task_title", "task_tag", "source_uri", "target_uri", "runtime_info", "user_value", "md5"}));
            sQLiteDatabase.execSQL(String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s INTEGER, %s INTEGER, %s INTEGER, %s TEXT, %s INTEGER)", new Object[]{"blocks", "block_id", "block_class", "block_index", "block_offset", "block_length", "runtime_info", "task_id"}));
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL(String.format("ALTER TABLE %s ADD COLUMN %s TEXT", new Object[]{"tasks", "md5"}));
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }
}
