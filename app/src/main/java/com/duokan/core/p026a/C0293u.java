package com.duokan.core.p026a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;


public abstract class C0293u {
    
    public static int m689a(Cursor cursor, int i) {
        return C0293u.m690a(cursor, i, 0);
    }

    
    public static int m690a(Cursor cursor, int i, int i2) {
        return (cursor == null || cursor.isNull(i)) ? i2 : cursor.getInt(i);
    }

    
    public static long m694b(Cursor cursor, int i) {
        return C0293u.m691a(cursor, i, 0);
    }

    
    public static long m691a(Cursor cursor, int i, long j) {
        return (cursor == null || cursor.isNull(i)) ? j : cursor.getLong(i);
    }

    
    public static String m695c(Cursor cursor, int i) {
        return C0293u.m692a(cursor, i, "");
    }

    
    public static String m692a(Cursor cursor, int i, String str) {
        return (cursor == null || cursor.isNull(i)) ? str : cursor.getString(i);
    }

    
    public static List<String> m693a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor rawQuery = sQLiteDatabase.rawQuery(String.format("PRAGMA table_info('%s')", new Object[]{str}), null);
        List<String> linkedList = new LinkedList();
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
