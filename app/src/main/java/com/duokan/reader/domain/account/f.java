package com.duokan.reader.domain.account;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import com.duokan.core.a.n;
import com.duokan.core.io.a;
import com.duokan.reader.ReaderEnv;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

import miui.payment.PaymentManager;

public class f {
    private static n a = null;

    public static n a() {
        if (a == null) {
            File file = new File(ReaderEnv.get().getDatabaseDirectory(), "Account.db");
            File file2 = new File(ReaderEnv.get().getExternalFilesDirectory(), "Account.db");
            a = new n(Uri.fromFile(file).toString(), Uri.fromFile(file2).toString());
            if (ReaderEnv.get().getBuildName().equals("MiReader") && a.d() < 4) {
                a.g();
                a.d(file);
                a.d(file2);
                a = new n(Uri.fromFile(file).toString(), Uri.fromFile(file2).toString());
            }
            a(a);
        }
        return a;
    }

    private static boolean a(n nVar) {
        boolean z = true;
        int d = nVar.d();
        if (d >= 5) {
            return true;
        }
        nVar.a(5);
        if (d == 0) {
            nVar.b();
            try {
                a(nVar, d);
                nVar.f();
                return z;
            } catch (Exception e) {
                z = e;
                z.printStackTrace();
                return false;
            } finally {
                nVar.c();
            }
        } else {
            nVar.b();
            try {
                if (!e(nVar, d)) {
                    return false;
                }
                if (!d(nVar, d)) {
                    nVar.c();
                    return false;
                } else if (!c(nVar, d)) {
                    nVar.c();
                    return false;
                } else if (b(nVar, d)) {
                    nVar.f();
                    nVar.c();
                    return true;
                } else {
                    nVar.c();
                    return false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            } finally {
                nVar.c();
            }
        }
    }

    private static void a(n nVar, int i) {
        if (i == 0) {
            d(nVar);
            g(nVar);
            h(nVar);
            f(nVar);
            e(nVar);
        }
    }

    private static void b(n nVar) {
        nVar.a(String.format("ALTER TABLE %s ADD COLUMN %s INTEGER", new Object[]{"statistics", "latest_month_reading_time"}));
        nVar.a(String.format("ALTER TABLE %s ADD COLUMN %s DOUBLE", new Object[]{"statistics", "latest_month_ranking_ratio"}));
    }

    private static void c(n nVar) {
        JSONException e;
        String str;
        bh a;
        ContentValues contentValues;
        long a2;
        n a3;
        JSONObject jSONObject;
        Object obj;
        ContentValues contentValues2;
        String str2 = null;
        Cursor a4 = nVar.a(String.format("SELECT * FROM %1$s WHERE %2$s IS '%3$s'", new Object[]{"accounts", "account_type", AccountType.XIAO_MI.name()}), (String[]) str2);
        Object obj2;
        String str3;
        if (a4 == null || a4.isAfterLast()) {
            obj2 = str2;
            str3 = str2;
        } else {
            String string;
            String string2;
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
                    str3 = string2;
                    str = str2;
                    str2 = string;
                    obj2 = str;
                    if (a4 != null) {
                        a4.close();
                    }
                    nVar.a(String.format("DROP TABLE %1$s", new Object[]{"accounts"}));
                    d(nVar);
                    if (a != null) {
                        nVar.b();
                        try {
                            contentValues = new ContentValues();
                            contentValues.put("account_type", r7);
                            contentValues.put("account_detail", a.toString());
                            contentValues.put("login_name", str2);
                            a2 = nVar.a("accounts", null, contentValues);
                            try {
                                nVar.f();
                                nVar.c();
                            } catch (Exception e3) {
                                e = e3;
                                try {
                                    Exception e4;
                                    e4.printStackTrace();
                                    a3 = ce.a();
                                    a3.b();
                                    jSONObject = new JSONObject();
                                    jSONObject.put("miPassToken", a.a);
                                    jSONObject.put("dushuServiceToken", a.b);
                                    jSONObject.put("login_token", obj);
                                    contentValues2 = new ContentValues();
                                    contentValues2.put("account_id", Long.valueOf(a2));
                                    contentValues2.put("tokens", jSONObject.toString());
                                    a3.a("tokens", null, contentValues2);
                                    a3.f();
                                } finally {
                                    nVar.c();
                                }
                            }
                        } catch (Exception e5) {
                            e4 = e5;
                            a2 = -1;
                            e4.printStackTrace();
                            a3 = ce.a();
                            a3.b();
                            jSONObject = new JSONObject();
                            jSONObject.put("miPassToken", a.a);
                            jSONObject.put("dushuServiceToken", a.b);
                            jSONObject.put("login_token", obj);
                            contentValues2 = new ContentValues();
                            contentValues2.put("account_id", Long.valueOf(a2));
                            contentValues2.put("tokens", jSONObject.toString());
                            a3.a("tokens", null, contentValues2);
                            a3.f();
                        }
                        a3 = ce.a();
                        a3.b();
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("miPassToken", a.a);
                            jSONObject.put("dushuServiceToken", a.b);
                            jSONObject.put("login_token", obj);
                        } catch (JSONException e6) {
                            e6.printStackTrace();
                        }
                        try {
                            contentValues2 = new ContentValues();
                            contentValues2.put("account_id", Long.valueOf(a2));
                            contentValues2.put("tokens", jSONObject.toString());
                            a3.a("tokens", null, contentValues2);
                            a3.f();
                        } catch (Exception e52) {
                            e52.printStackTrace();
                            return;
                        } finally {
                            a3.c();
                        }
                    }
                }
                try {
                    obj = string2;
                    str2 = string;
                    a = bh.a(string, jSONObject2, null);
                } catch (JSONException e7) {
                    e = e7;
                    e.printStackTrace();
                    str3 = string2;
                    str = str2;
                    str2 = string;
                    obj2 = str;
                    if (a4 != null) {
                        a4.close();
                    }
                    nVar.a(String.format("DROP TABLE %1$s", new Object[]{"accounts"}));
                    d(nVar);
                    if (a != null) {
                        nVar.b();
                        contentValues = new ContentValues();
                        contentValues.put("account_type", r7);
                        contentValues.put("account_detail", a.toString());
                        contentValues.put("login_name", str2);
                        a2 = nVar.a("accounts", null, contentValues);
                        nVar.f();
                        nVar.c();
                        a3 = ce.a();
                        a3.b();
                        jSONObject = new JSONObject();
                        jSONObject.put("miPassToken", a.a);
                        jSONObject.put("dushuServiceToken", a.b);
                        jSONObject.put("login_token", obj);
                        contentValues2 = new ContentValues();
                        contentValues2.put("account_id", Long.valueOf(a2));
                        contentValues2.put("tokens", jSONObject.toString());
                        a3.a("tokens", null, contentValues2);
                        a3.f();
                    }
                }
            } catch (JSONException e8) {
                e = e8;
                string2 = str2;
                string = str2;
                e.printStackTrace();
                str3 = string2;
                str = str2;
                str2 = string;
                obj2 = str;
                if (a4 != null) {
                    a4.close();
                }
                nVar.a(String.format("DROP TABLE %1$s", new Object[]{"accounts"}));
                d(nVar);
                if (a != null) {
                    nVar.b();
                    contentValues = new ContentValues();
                    contentValues.put("account_type", r7);
                    contentValues.put("account_detail", a.toString());
                    contentValues.put("login_name", str2);
                    a2 = nVar.a("accounts", null, contentValues);
                    nVar.f();
                    nVar.c();
                    a3 = ce.a();
                    a3.b();
                    jSONObject = new JSONObject();
                    jSONObject.put("miPassToken", a.a);
                    jSONObject.put("dushuServiceToken", a.b);
                    jSONObject.put("login_token", obj);
                    contentValues2 = new ContentValues();
                    contentValues2.put("account_id", Long.valueOf(a2));
                    contentValues2.put("tokens", jSONObject.toString());
                    a3.a("tokens", null, contentValues2);
                    a3.f();
                }
            }
        }
        if (a4 != null) {
            a4.close();
        }
        nVar.a(String.format("DROP TABLE %1$s", new Object[]{"accounts"}));
        d(nVar);
        if (a != null) {
            nVar.b();
            contentValues = new ContentValues();
            contentValues.put("account_type", r7);
            contentValues.put("account_detail", a.toString());
            contentValues.put("login_name", str2);
            a2 = nVar.a("accounts", null, contentValues);
            nVar.f();
            nVar.c();
            a3 = ce.a();
            a3.b();
            jSONObject = new JSONObject();
            jSONObject.put("miPassToken", a.a);
            jSONObject.put("dushuServiceToken", a.b);
            jSONObject.put("login_token", obj);
            contentValues2 = new ContentValues();
            contentValues2.put("account_id", Long.valueOf(a2));
            contentValues2.put("tokens", jSONObject.toString());
            a3.a("tokens", null, contentValues2);
            a3.f();
        }
    }

    private static boolean b(n nVar, int i) {
        if (i < 5) {
            b(nVar);
        }
        return true;
    }

    private static boolean c(n nVar, int i) {
        if (i < 4) {
            c(nVar);
        }
        return true;
    }

    private static boolean d(n nVar, int i) {
        if (i < 3) {
            e(nVar);
        }
        return true;
    }

    private static boolean e(n nVar, int i) {
        if (i < 2) {
            g(nVar);
            h(nVar);
            f(nVar);
        }
        return true;
    }

    private static void d(n nVar) {
        nVar.a(String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", new Object[]{"accounts", "account_id", "account_type", "account_detail", "login_name", "login_token"}));
    }

    private static void e(n nVar) {
        nVar.a(String.format("CREATE TABLE IF NOT EXISTS %s(%s INTEGER PRIMARY KEY,  %s TEXT,  %s TEXT,  %s TEXT);", new Object[]{"unverified_order", "_id", PaymentManager.KEY_ACCOUNT, "book_order", "receipt"}));
    }

    private static void f(n nVar) {
        nVar.a(String.format("CREATE TABLE IF NOT EXISTS %s(%s INTEGER PRIMARY KEY,  %s TEXT UNIQUE,  %s TEXT,  %s TEXT,  %s TEXT,  %s TEXT,  %s SMALLINT,  %s LONG,  %s SMALLINT);", new Object[]{"messages", "_id", "msg_id", "title", "msg_content", "msg_type", "action_params", "read", "received_date", "replied"}));
    }

    private static void g(n nVar) {
        nVar.a(String.format("CREATE TABLE IF NOT EXISTS %s(%s INTEGER PRIMARY KEY,  %s LONG UNIQUE,  %s INTEGER,  %s INTEGER,  %s INTEGER,  %s INTEGER,  %s INTEGER,  %s DOUBLE,  %s BLOB,  %s INTEGER,  %s INTEGER,  %s BLOB,  %s INTEGER,  %s INTEGER,  %s DOUBLE);", new Object[]{"statistics", "_id", "owner_id", "total_reading_books", "total_seconds", "total_books", "total_completed_books", "total_days", "ranking_ratio", "reading_distribution", "new_read_pages", "new_read_seconds", "new_distribution", "last_sync_time", "latest_month_reading_time", "latest_month_ranking_ratio"}));
    }

    private static void h(n nVar) {
        nVar.a(String.format("CREATE TABLE IF NOT EXISTS %s( %s TEXT,  %s TEXT,  %s TEXT,  %s TEXT,  %s TEXT,  %s BLOB,  %s BLOB);", new Object[]{"paid_chapters", "book_uuid", "book_title", "authors", "cover_uri", "latest_purchased_date", "paid_chapters_id", "paid_date"}));
    }
}
