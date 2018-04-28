package com.duokan.core.sys;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.duokan.core.p026a.C0285n;
import java.util.Locale;
import java.util.regex.Pattern;

abstract class au {
    /* renamed from: a */
    private static final Pattern f655a = Pattern.compile("-");

    /* renamed from: a */
    public static Cursor m888a(C0285n c0285n, String str, String... strArr) {
        return c0285n.m670a(String.format(Locale.getDefault(), "SELECT %2$s FROM %1$s WHERE %3$s='%4$s' ORDER BY %5$s ASC", new Object[]{"repositories", m890a(strArr), "mount_uri", str, "repo_name"}), new String[0]);
    }

    /* renamed from: a */
    public static void m892a(C0285n c0285n, ContentValues contentValues) {
        c0285n.m669a("repositories", null, contentValues, 5);
    }

    /* renamed from: a */
    public static void m891a(C0285n c0285n) {
        c0285n.m673a(String.format(Locale.getDefault(), "CREATE TABLE IF NOT EXISTS %1$s(%2$s TEXT PRIMARY KEY, %3$s TEXT, %4$s TEXT UNIQUE)", new Object[]{"repositories", "repo_name", "physical_uri", "mount_uri"}));
    }

    /* renamed from: b */
    public static void m897b(C0285n c0285n) {
        c0285n.m673a(String.format(Locale.getDefault(), "CREATE TABLE IF NOT EXISTS %1$s(%2$s TEXT PRIMARY KEY, %3$s TEXT UNIQUE, %4$s INTEGER, %5$s INTEGER, %6$s INTEGER, %7$s INTEGER, %8$s TEXT, %9$s INTEGER, %10$s TEXT)", new Object[]{"files", "storage_uri", "space_uri", "file_size", "creation_time", "last_access_time", "last_write_time", "owner", "attributes", "metadata"}));
    }

    /* renamed from: b */
    public static Cursor m896b(C0285n c0285n, String str, String... strArr) {
        return c0285n.m670a(String.format(Locale.getDefault(), "SELECT %2$s FROM %1$s WHERE %3$s='%4$s' ORDER BY %5$s ASC", new Object[]{"files", m890a(strArr), "storage_uri", str, "storage_uri"}), new String[0]);
    }

    /* renamed from: c */
    public static Cursor m899c(C0285n c0285n, String str, String... strArr) {
        return c0285n.m670a(String.format(Locale.getDefault(), "SELECT %2$s FROM %1$s WHERE %3$s GLOB '%4$s' ORDER BY %5$s ASC", new Object[]{"files", m890a(strArr), "storage_uri", str, "storage_uri"}), new String[0]);
    }

    /* renamed from: a */
    public static void m893a(C0285n c0285n, String str) {
        c0285n.m673a(String.format(Locale.getDefault(), "DELETE FROM %1$s WHERE %2$s='%3$s'", new Object[]{"files", "storage_uri", str}));
    }

    /* renamed from: b */
    public static void m898b(C0285n c0285n, ContentValues contentValues) {
        c0285n.m675b("files", null, contentValues);
    }

    /* renamed from: a */
    public static void m894a(C0285n c0285n, String str, ContentValues contentValues) {
        if (c0285n.m666a("files", contentValues, String.format(Locale.getDefault(), "%1$s='%2$s'", new Object[]{"storage_uri", str}), null) != 1) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: c */
    public static void m900c(C0285n c0285n) {
        c0285n.m673a(String.format(Locale.getDefault(), "CREATE TABLE IF NOT EXISTS %1$s(%2$s TEXT PRIMARY KEY, %3$s INTEGER, %4$s INTEGER, %5$s INTEGER)", new Object[]{"spaces", "uri", "offset", "size", "state"}));
    }

    /* renamed from: d */
    public static Cursor m902d(C0285n c0285n, String str, String... strArr) {
        return c0285n.m670a(String.format(Locale.getDefault(), "SELECT %2$s FROM %1$s WHERE %3$s GLOB '%4$s' ORDER BY %5$s ASC", new Object[]{"spaces", m890a(strArr), "uri", str, "offset"}), new String[0]);
    }

    /* renamed from: c */
    public static void m901c(C0285n c0285n, ContentValues contentValues) {
        c0285n.m675b("spaces", null, contentValues);
    }

    /* renamed from: a */
    public static long[] m895a(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return new long[0];
        }
        CharSequence substring = str.substring(str.lastIndexOf(47) + 1, str.length());
        if (TextUtils.isEmpty(substring)) {
            return new long[0];
        }
        String[] split = f655a.split(substring);
        long[] jArr = new long[split.length];
        while (i < split.length) {
            jArr[i] = Long.parseLong(split[i]);
            i++;
        }
        return jArr;
    }

    /* renamed from: a */
    public static String m889a(String str, long... jArr) {
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

    /* renamed from: a */
    private static String m890a(String... strArr) {
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
