package com.duokan.core.sys;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;

import com.duokan.core.a.n;

import java.util.Locale;
import java.util.regex.Pattern;

abstract class au {
    private static final Pattern a = Pattern.compile("-");

    public static Cursor a(n nVar, String str, String... strArr) {
        return nVar.a(String.format(Locale.getDefault(), "SELECT %2$s FROM %1$s WHERE %3$s='%4$s' ORDER BY %5$s ASC", new Object[]{"repositories", a(strArr), "mount_uri", str, "repo_name"}), new String[0]);
    }

    public static void a(n nVar, ContentValues contentValues) {
        nVar.a("repositories", null, contentValues, 5);
    }

    public static void a(n nVar) {
        nVar.a(String.format(Locale.getDefault(), "CREATE TABLE IF NOT EXISTS %1$s(%2$s TEXT PRIMARY KEY, %3$s TEXT, %4$s TEXT UNIQUE)", new Object[]{"repositories", "repo_name", "physical_uri", "mount_uri"}));
    }

    public static void b(n nVar) {
        nVar.a(String.format(Locale.getDefault(), "CREATE TABLE IF NOT EXISTS %1$s(%2$s TEXT PRIMARY KEY, %3$s TEXT UNIQUE, %4$s INTEGER, %5$s INTEGER, %6$s INTEGER, %7$s INTEGER, %8$s TEXT, %9$s INTEGER, %10$s TEXT)", new Object[]{"files", "storage_uri", "space_uri", "file_size", "creation_time", "last_access_time", "last_write_time", "owner", "attributes", "metadata"}));
    }

    public static Cursor b(n nVar, String str, String... strArr) {
        return nVar.a(String.format(Locale.getDefault(), "SELECT %2$s FROM %1$s WHERE %3$s='%4$s' ORDER BY %5$s ASC", new Object[]{"files", a(strArr), "storage_uri", str, "storage_uri"}), new String[0]);
    }

    public static Cursor c(n nVar, String str, String... strArr) {
        return nVar.a(String.format(Locale.getDefault(), "SELECT %2$s FROM %1$s WHERE %3$s GLOB '%4$s' ORDER BY %5$s ASC", new Object[]{"files", a(strArr), "storage_uri", str, "storage_uri"}), new String[0]);
    }

    public static void a(n nVar, String str) {
        nVar.a(String.format(Locale.getDefault(), "DELETE FROM %1$s WHERE %2$s='%3$s'", new Object[]{"files", "storage_uri", str}));
    }

    public static void b(n nVar, ContentValues contentValues) {
        nVar.b("files", null, contentValues);
    }

    public static void a(n nVar, String str, ContentValues contentValues) {
        if (nVar.a("files", contentValues, String.format(Locale.getDefault(), "%1$s='%2$s'", new Object[]{"storage_uri", str}), null) != 1) {
            throw new IllegalArgumentException();
        }
    }

    public static void c(n nVar) {
        nVar.a(String.format(Locale.getDefault(), "CREATE TABLE IF NOT EXISTS %1$s(%2$s TEXT PRIMARY KEY, %3$s INTEGER, %4$s INTEGER, %5$s INTEGER)", new Object[]{"spaces", "uri", "offset", "size", "state"}));
    }

    public static Cursor d(n nVar, String str, String... strArr) {
        return nVar.a(String.format(Locale.getDefault(), "SELECT %2$s FROM %1$s WHERE %3$s GLOB '%4$s' ORDER BY %5$s ASC", new Object[]{"spaces", a(strArr), "uri", str, "offset"}), new String[0]);
    }

    public static void c(n nVar, ContentValues contentValues) {
        nVar.b("spaces", null, contentValues);
    }

    public static long[] a(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return new long[0];
        }
        CharSequence substring = str.substring(str.lastIndexOf(47) + 1, str.length());
        if (TextUtils.isEmpty(substring)) {
            return new long[0];
        }
        String[] split = a.split(substring);
        long[] jArr = new long[split.length];
        while (i < split.length) {
            jArr[i] = Long.parseLong(split[i]);
            i++;
        }
        return jArr;
    }

    public static String a(String str, long... jArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append('/');
        if (jArr.length < 1) {
            stringBuilder.append('*');
        } else {
            for (int i = 0; i < jArr.length; i++) {
                if (i > 0) {
                    stringBuilder.append('-');
                }
                stringBuilder.append(jArr[i]);
            }
        }
        return stringBuilder.toString();
    }

    private static String a(String... strArr) {
        if (strArr.length < 1) {
            return "*";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            stringBuilder.append(strArr[i]);
            if (i < strArr.length - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }
}
