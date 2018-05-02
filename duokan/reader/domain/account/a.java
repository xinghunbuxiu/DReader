package com.duokan.reader.domain.account;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;

import com.duokan.core.a.n;
import com.duokan.reader.ReaderEnv;
import com.xiaomi.micloudsdk.request.Request.RequestEnv;

import org.apache.http.protocol.HTTP;

import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public abstract class a implements aa {
    static final /* synthetic */ boolean d = (!a.class.desiredAssertionStatus());
    protected final e a;
    protected final n b;
    protected final n c;
    private long e = -1;

    public abstract void a(Activity activity, d dVar);

    public abstract void a(c cVar);

    protected abstract void a(String str, String str2, String str3);

    public abstract String b();

    public abstract String c();

    public abstract String d();

    public abstract AccountType e();

    public abstract g f();

    public abstract Map g();

    public abstract Map h();

    public abstract boolean i();

    public abstract RequestEnv j();

    protected abstract String m();

    public a(e eVar) {
        this.a = eVar;
        this.b = this.a.a();
        this.c = this.a.b();
    }

    public long a() {
        return this.e;
    }

    protected void k() {
        Cursor a;
        Exception e;
        Throwable th;
        Cursor cursor = null;
        synchronized (this.b) {
            try {
                AccountType e2 = e();
                a = this.b.a(String.format("SELECT * FROM %1$s WHERE %2$s IS '%3$s'", new Object[]{"accounts", "account_type", e2.name()}), null);
                if (a != null) {
                    try {
                        if (!a.isAfterLast()) {
                            a.moveToLast();
                            this.e = a.getLong(0);
                            String string = a.getString(a.getColumnIndex("login_name"));
                            String string2 = a.getString(a.getColumnIndex("account_detail"));
                            cursor = this.c.a(String.format("SELECT * FROM %1$s WHERE %2$s IS '%3$s'", new Object[]{"tokens", "account_id", this.e + ""}), null);
                            if (cursor.moveToLast()) {
                                String string3 = cursor.getString(cursor.getColumnIndex("tokens"));
                                try {
                                    a(string, string2, b(string3));
                                } catch (Exception e3) {
                                    a(string, string2, string3);
                                    l();
                                }
                            } else {
                                a(string, string2, "");
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        try {
                            e.printStackTrace();
                            if (a != null) {
                                a.close();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (a != null) {
                                a.close();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                }
                if (a != null) {
                    a.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e5) {
                e = e5;
                a = null;
                e.printStackTrace();
                if (a != null) {
                    a.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th3) {
                th = th3;
                a = null;
                if (a != null) {
                    a.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    protected void l() {
        Cursor cursor = null;
        synchronized (this.b) {
            if (this.e < 0) {
                try {
                    cursor = this.b.a(String.format("SELECT * FROM %1$s WHERE lower(%2$s) IS lower('%3$s') AND %4$s IS '%5$s'", new Object[]{"accounts", "login_name", c(), "account_type", e().name()}), null);
                    if (!(cursor == null || cursor.isAfterLast())) {
                        cursor.moveToLast();
                        this.e = cursor.getLong(0);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
            if (this.e < 0) {
                n();
                return;
            }
            this.b.b();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("account_type", e().name());
                contentValues.put("account_detail", f().toString());
                contentValues.put("login_name", c());
                this.b.a("accounts", contentValues, "account_id = " + this.e, null);
                this.b.f();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
            this.c.b();
            try {
                contentValues = new ContentValues();
                contentValues.put("account_id", Long.valueOf(this.e));
                contentValues.put("tokens", a(m()));
                if (this.c.a("tokens", contentValues, "account_id=" + this.e, null) <= 0) {
                    this.c.a("tokens", null, contentValues);
                }
                this.c.f();
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            } finally {
                this.c.c();
            }
        }
        this.b.c();
    }

    private void n() {
        if (d || this.e < 0) {
            synchronized (this.b) {
                ContentValues contentValues;
                this.b.b();
                try {
                    contentValues = new ContentValues();
                    contentValues.put("account_type", e().name());
                    contentValues.put("account_detail", f().toString());
                    contentValues.put("login_name", c());
                    this.e = this.b.a("accounts", null, contentValues);
                    this.b.f();
                    this.b.c();
                } catch (Exception e) {
                    e.printStackTrace();
                    this.b.c();
                } catch (Throwable th) {
                    this.b.c();
                }
                this.c.b();
                try {
                    contentValues = new ContentValues();
                    contentValues.put("account_id", Long.valueOf(this.e));
                    contentValues.put("tokens", a(m()));
                    this.c.a("tokens", null, contentValues);
                    this.c.f();
                } catch (Exception e2) {
                    e2.printStackTrace();
                } finally {
                    this.c.c();
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public static String a(String str) {
        return a(a(o(), str.getBytes()));
    }

    public static String b(String str) {
        return new String(b(o(), c(str)));
    }

    private static byte[] o() {
        return new SecretKeySpec(Arrays.copyOf(MessageDigest.getInstance("SHA-1").digest(ReaderEnv.get().getDeviceId().getBytes(HTTP.UTF_8)), 16), "AES").getEncoded();
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES");
        instance.init(1, secretKeySpec);
        return instance.doFinal(bArr2);
    }

    private static byte[] b(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES");
        instance.init(2, secretKeySpec);
        return instance.doFinal(bArr2);
    }

    public static byte[] c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = Integer.valueOf(str.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        return bArr;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte a : bArr) {
            a(stringBuffer, a);
        }
        return stringBuffer.toString();
    }

    private static void a(StringBuffer stringBuffer, byte b) {
        stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15)).append("0123456789ABCDEF".charAt(b & 15));
    }
}
