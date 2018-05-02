package com.duokan.reader.domain.account;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.duokan.core.io.FileUtil;
import com.duokan.core.p026a.C0285n;
import com.duokan.reader.ReaderEnv;
import java.io.File;
import miui.payment.PaymentManager;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.account.f */
public class C0707f {
    /* renamed from: a */
    private static C0285n f2472a = null;

    /* renamed from: a */
    public static C0285n m3460a() {
        if (f2472a == null) {
            File file = new File(ReaderEnv.get().getDatabaseDirectory(), "Account.db");
            File file2 = new File(ReaderEnv.get().getExternalFilesDirectory(), "Account.db");
            f2472a = new C0285n(Uri.fromFile(file).toString(), Uri.fromFile(file2).toString());
            if (ReaderEnv.get().getBuildName().equals("MiReader") && f2472a.m679d() < 4) {
                f2472a.m682g();
                FileUtil.deleteFile(file);
                FileUtil.deleteFile(file2);
                f2472a = new C0285n(Uri.fromFile(file).toString(), Uri.fromFile(file2).toString());
            }
            C0707f.m3462a(f2472a);
        }
        return f2472a;
    }

    /* renamed from: a */
    private static boolean m3462a(C0285n c0285n) {
        boolean z = true;
        int d = c0285n.m679d();
        if (d >= 5) {
            return true;
        }
        c0285n.m672a(5);
        if (d == 0) {
            c0285n.m677b();
            try {
                C0707f.m3461a(c0285n, d);
                c0285n.m681f();
                return z;
            } catch (Exception e) {
                z = e;
                z.printStackTrace();
                return false;
            } finally {
                c0285n.m678c();
            }
        } else {
            c0285n.m677b();
            try {
                if (!C0707f.m3470e(c0285n, d)) {
                    return false;
                }
                if (!C0707f.m3468d(c0285n, d)) {
                    c0285n.m678c();
                    return false;
                } else if (!C0707f.m3466c(c0285n, d)) {
                    c0285n.m678c();
                    return false;
                } else if (C0707f.m3464b(c0285n, d)) {
                    c0285n.m681f();
                    c0285n.m678c();
                    return true;
                } else {
                    c0285n.m678c();
                    return false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            } finally {
                c0285n.m678c();
            }
        }
    }

    /* renamed from: a */
    private static void m3461a(C0285n c0285n, int i) {
        if (i == 0) {
            C0707f.m3467d(c0285n);
            C0707f.m3472g(c0285n);
            C0707f.m3473h(c0285n);
            C0707f.m3471f(c0285n);
            C0707f.m3469e(c0285n);
        }
    }

    /* renamed from: b */
    private static void m3463b(C0285n c0285n) {
        c0285n.m673a(String.format("ALTER TABLE %s ADD COLUMN %s INTEGER", new Object[]{"statistics", "latest_month_reading_time"}));
        c0285n.m673a(String.format("ALTER TABLE %s ADD COLUMN %s DOUBLE", new Object[]{"statistics", "latest_month_ranking_ratio"}));
    }

    /* renamed from: c */
    private static void m3465c(C0285n c0285n) {
        String string;
        String string2;
        JSONException e;
        String str;
        bd a;
        ContentValues contentValues;
        long a2;
        C0285n a3;
        JSONObject jSONObject;
        Object obj;
        ContentValues contentValues2;
        String str2 = null;
        Cursor a4 = c0285n.m670a(String.format("SELECT * FROM %1$s WHERE %2$s IS '%3$s'", new Object[]{"accounts", "account_type", AccountType.XIAO_MI.name()}), (String[]) str2);
        Object a5;
        String obj2;
        if (a4 == null || a4.isAfterLast()) {
            a5 = str2;
            obj2 = str2;
        } else {
            try {
                a4.moveToLast();
                JSONObject jSONObject2 = new JSONObject(a4.getString(a4.getColumnIndex("account_detail")));
                string = a4.getString(a4.getColumnIndex("login_name"));
                try {
                    string2 = a4.getString(a4.getColumnIndex("login_token"));
                } catch (JSONException e2) {
                    e = e2;
                    string2 = str2;
                    e.printStackTrace();
                    obj2 = string2;
                    str = str2;
                    str2 = string;
                    a5 = str;
                    if (a4 != null) {
                        a4.close();
                    }
                    c0285n.m673a(String.format("DROP TABLE %1$s", new Object[]{"accounts"}));
                    C0707f.m3467d(c0285n);
                    if (a5 != null) {
                        c0285n.m677b();
                        try {
                            contentValues = new ContentValues();
                            contentValues.put("account_type", r7);
                            contentValues.put("account_detail", a5.toString());
                            contentValues.put("login_name", str2);
                            a2 = c0285n.m668a("accounts", null, contentValues);
                            try {
                                c0285n.m681f();
                                c0285n.m678c();
                            } catch (Exception e3) {
                                e = e3;
                                try {
                                    Exception e4;
                                    e4.printStackTrace();
                                    a3 = ci.m3438a();
                                    a3.m677b();
                                    jSONObject = new JSONObject();
                                    jSONObject.put("miPassToken", a5.f2401a);
                                    jSONObject.put("dushuServiceToken", a5.f2402b);
                                    jSONObject.put("login_token", obj2);
                                    contentValues2 = new ContentValues();
                                    contentValues2.put("account_id", Long.valueOf(a2));
                                    contentValues2.put("tokens", jSONObject.toString());
                                    a3.m668a("tokens", null, contentValues2);
                                    a3.m681f();
                                } finally {
                                    c0285n.m678c();
                                }
                            }
                        } catch (Exception e5) {
                            e4 = e5;
                            a2 = -1;
                            e4.printStackTrace();
                            a3 = ci.m3438a();
                            a3.m677b();
                            jSONObject = new JSONObject();
                            jSONObject.put("miPassToken", a5.f2401a);
                            jSONObject.put("dushuServiceToken", a5.f2402b);
                            jSONObject.put("login_token", obj2);
                            contentValues2 = new ContentValues();
                            contentValues2.put("account_id", Long.valueOf(a2));
                            contentValues2.put("tokens", jSONObject.toString());
                            a3.m668a("tokens", null, contentValues2);
                            a3.m681f();
                        }
                        a3 = ci.m3438a();
                        a3.m677b();
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("miPassToken", a5.f2401a);
                            jSONObject.put("dushuServiceToken", a5.f2402b);
                            jSONObject.put("login_token", obj2);
                        } catch (JSONException e6) {
                            e6.printStackTrace();
                        }
                        try {
                            contentValues2 = new ContentValues();
                            contentValues2.put("account_id", Long.valueOf(a2));
                            contentValues2.put("tokens", jSONObject.toString());
                            a3.m668a("tokens", null, contentValues2);
                            a3.m681f();
                        } catch (Exception e52) {
                            e52.printStackTrace();
                            return;
                        } finally {
                            a3.m678c();
                        }
                    }
                }
                try {
                    obj2 = string2;
                    str2 = string;
                    a5 = bd.m3400a(string, jSONObject2, null);
                } catch (JSONException e7) {
                    e = e7;
                    e.printStackTrace();
                    obj2 = string2;
                    str = str2;
                    str2 = string;
                    a5 = str;
                    if (a4 != null) {
                        a4.close();
                    }
                    c0285n.m673a(String.format("DROP TABLE %1$s", new Object[]{"accounts"}));
                    C0707f.m3467d(c0285n);
                    if (a5 != null) {
                        c0285n.m677b();
                        contentValues = new ContentValues();
                        contentValues.put("account_type", r7);
                        contentValues.put("account_detail", a5.toString());
                        contentValues.put("login_name", str2);
                        a2 = c0285n.m668a("accounts", null, contentValues);
                        c0285n.m681f();
                        c0285n.m678c();
                        a3 = ci.m3438a();
                        a3.m677b();
                        jSONObject = new JSONObject();
                        jSONObject.put("miPassToken", a5.f2401a);
                        jSONObject.put("dushuServiceToken", a5.f2402b);
                        jSONObject.put("login_token", obj2);
                        contentValues2 = new ContentValues();
                        contentValues2.put("account_id", Long.valueOf(a2));
                        contentValues2.put("tokens", jSONObject.toString());
                        a3.m668a("tokens", null, contentValues2);
                        a3.m681f();
                    }
                }
            } catch (JSONException e8) {
                e = e8;
                string2 = str2;
                string = str2;
                e.printStackTrace();
                obj2 = string2;
                str = str2;
                str2 = string;
                a5 = str;
                if (a4 != null) {
                    a4.close();
                }
                c0285n.m673a(String.format("DROP TABLE %1$s", new Object[]{"accounts"}));
                C0707f.m3467d(c0285n);
                if (a5 != null) {
                    c0285n.m677b();
                    contentValues = new ContentValues();
                    contentValues.put("account_type", r7);
                    contentValues.put("account_detail", a5.toString());
                    contentValues.put("login_name", str2);
                    a2 = c0285n.m668a("accounts", null, contentValues);
                    c0285n.m681f();
                    c0285n.m678c();
                    a3 = ci.m3438a();
                    a3.m677b();
                    jSONObject = new JSONObject();
                    jSONObject.put("miPassToken", a5.f2401a);
                    jSONObject.put("dushuServiceToken", a5.f2402b);
                    jSONObject.put("login_token", obj2);
                    contentValues2 = new ContentValues();
                    contentValues2.put("account_id", Long.valueOf(a2));
                    contentValues2.put("tokens", jSONObject.toString());
                    a3.m668a("tokens", null, contentValues2);
                    a3.m681f();
                }
            }
        }
        if (a4 != null) {
            a4.close();
        }
        c0285n.m673a(String.format("DROP TABLE %1$s", new Object[]{"accounts"}));
        C0707f.m3467d(c0285n);
        if (a5 != null) {
            c0285n.m677b();
            contentValues = new ContentValues();
            contentValues.put("account_type", r7);
            contentValues.put("account_detail", a5.toString());
            contentValues.put("login_name", str2);
            a2 = c0285n.m668a("accounts", null, contentValues);
            c0285n.m681f();
            c0285n.m678c();
            a3 = ci.m3438a();
            a3.m677b();
            jSONObject = new JSONObject();
            jSONObject.put("miPassToken", a5.f2401a);
            jSONObject.put("dushuServiceToken", a5.f2402b);
            jSONObject.put("login_token", obj2);
            contentValues2 = new ContentValues();
            contentValues2.put("account_id", Long.valueOf(a2));
            contentValues2.put("tokens", jSONObject.toString());
            a3.m668a("tokens", null, contentValues2);
            a3.m681f();
        }
    }

    /* renamed from: b */
    private static boolean m3464b(C0285n c0285n, int i) {
        if (i < 5) {
            C0707f.m3463b(c0285n);
        }
        return true;
    }

    /* renamed from: c */
    private static boolean m3466c(C0285n c0285n, int i) {
        if (i < 4) {
            C0707f.m3465c(c0285n);
        }
        return true;
    }

    /* renamed from: d */
    private static boolean m3468d(C0285n c0285n, int i) {
        if (i < 3) {
            C0707f.m3469e(c0285n);
        }
        return true;
    }

    /* renamed from: e */
    private static boolean m3470e(C0285n c0285n, int i) {
        if (i < 2) {
            C0707f.m3472g(c0285n);
            C0707f.m3473h(c0285n);
            C0707f.m3471f(c0285n);
        }
        return true;
    }

    /* renamed from: d */
    private static void m3467d(C0285n c0285n) {
        c0285n.m673a(String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", new Object[]{"accounts", "account_id", "account_type", "account_detail", "login_name", "login_token"}));
    }

    /* renamed from: e */
    private static void m3469e(C0285n c0285n) {
        c0285n.m673a(String.format("CREATE TABLE IF NOT EXISTS %s(%s INTEGER PRIMARY KEY,  %s TEXT,  %s TEXT,  %s TEXT);", new Object[]{"unverified_order", "_id", PaymentManager.KEY_ACCOUNT, "book_order", "receipt"}));
    }

    /* renamed from: f */
    private static void m3471f(C0285n c0285n) {
        c0285n.m673a(String.format("CREATE TABLE IF NOT EXISTS %s(%s INTEGER PRIMARY KEY,  %s TEXT UNIQUE,  %s TEXT,  %s TEXT,  %s TEXT,  %s TEXT,  %s SMALLINT,  %s LONG,  %s SMALLINT);", new Object[]{"messages", "_id", "msg_id", "title", "msg_content", "msg_type", "action_params", "read", "received_date", "replied"}));
    }

    /* renamed from: g */
    private static void m3472g(C0285n c0285n) {
        c0285n.m673a(String.format("CREATE TABLE IF NOT EXISTS %s(%s INTEGER PRIMARY KEY,  %s LONG UNIQUE,  %s INTEGER,  %s INTEGER,  %s INTEGER,  %s INTEGER,  %s INTEGER,  %s DOUBLE,  %s BLOB,  %s INTEGER,  %s INTEGER,  %s BLOB,  %s INTEGER,  %s INTEGER,  %s DOUBLE);", new Object[]{"statistics", "_id", "owner_id", "total_reading_books", "total_seconds", "total_books", "total_completed_books", "total_days", "ranking_ratio", "reading_distribution", "new_read_pages", "new_read_seconds", "new_distribution", "last_sync_time", "latest_month_reading_time", "latest_month_ranking_ratio"}));
    }

    /* renamed from: h */
    private static void m3473h(C0285n c0285n) {
        c0285n.m673a(String.format("CREATE TABLE IF NOT EXISTS %s( %s TEXT,  %s TEXT,  %s TEXT,  %s TEXT,  %s TEXT,  %s BLOB,  %s BLOB);", new Object[]{"paid_chapters", "book_uuid", "book_title", "authors", "cover_uri", "latest_purchased_date", "paid_chapters_id", "paid_date"}));
    }
}
