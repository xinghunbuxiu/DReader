package com.duokan.core.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

public abstract class u {
    public static int a(Cursor cursor, int i) {
        return a(cursor, i, 0);
    }

    public static int a(Cursor cursor, int i, int i2) {
        return (cursor == null || cursor.isNull(i)) ? i2 : cursor.getInt(i);
    }

    public static long b(Cursor cursor, int i) {
        return a(cursor, i, 0);
    }

    public static long a(Cursor cursor, int i, long j) {
        return (cursor == null || cursor.isNull(i)) ? j : cursor.getLong(i);
    }

    public static String c(Cursor cursor, int i) {
        return a(cursor, i, "");
    }

    public static String a(Cursor cursor, int i, String str) {
        return (cursor == null || cursor.isNull(i)) ? str : cursor.getString(i);
    }

    public static List a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor rawQuery = sQLiteDatabase.rawQuery(String.format("PRAGMA table_info('%s')", new Object[]{str}), null);
        List linkedList = new LinkedList();
        while (rawQuery.moveToNext()) {
            try {
                linkedList.add(rawQuery.getString(rawQuery.getColumnIndex("name")));
            } catch (Throwable th) {
            } finally {
                rawQuery.close();
            }
        }
        return linkedList;
    }
}
