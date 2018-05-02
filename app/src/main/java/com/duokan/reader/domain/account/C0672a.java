package com.duokan.reader.domain.account;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import com.duokan.core.p026a.C0285n;
import com.duokan.reader.ReaderEnv;
import com.xiaomi.micloudsdk.request.Request.RequestEnv;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.protocol.HTTP;

/* renamed from: com.duokan.reader.domain.account.a */
public abstract class C0672a implements ah {
    /* renamed from: d */
    static final /* synthetic */ boolean f2241d = (!C0672a.class.desiredAssertionStatus());
    /* renamed from: a */
    protected final C0706e f2242a;
    /* renamed from: b */
    protected final C0285n f2243b;
    /* renamed from: c */
    protected final C0285n f2244c;
    /* renamed from: e */
    private long f2245e = -1;

    /* renamed from: a */
    public abstract void mo829a(Activity activity, C0700d c0700d);

    /* renamed from: a */
    public abstract void mo830a(C0699c c0699c);

    /* renamed from: a */
    protected abstract void mo831a(String str, String str2, String str3);

    /* renamed from: b */
    public abstract String mo832b();

    /* renamed from: c */
    public abstract String mo833c();

    /* renamed from: d */
    public abstract String mo834d();

    /* renamed from: e */
    public abstract AccountType mo835e();

    /* renamed from: f */
    public abstract C0705g mo836f();

    /* renamed from: g */
    public abstract Map<String, String> mo837g();

    /* renamed from: h */
    public abstract Map<String, String> mo838h();

    /* renamed from: i */
    public abstract boolean mo839i();

    /* renamed from: j */
    public abstract RequestEnv mo840j();

    /* renamed from: m */
    protected abstract String mo842m();

    public C0672a(C0706e c0706e) {
        this.f2242a = c0706e;
        this.f2243b = this.f2242a.mo875a();
        this.f2244c = this.f2242a.mo879b();
    }

    /* renamed from: a */
    public long mo853a() {
        return this.f2245e;
    }

    /* renamed from: k */
    protected void mo841k() {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        synchronized (this.f2243b) {
            Cursor a;
            try {
                AccountType e2 = mo835e();
                a = this.f2243b.m670a(String.format("SELECT * FROM %1$s WHERE %2$s IS '%3$s'", new Object[]{"accounts", "account_type", e2.name()}), null);
                if (a != null) {
                    try {
                        if (!a.isAfterLast()) {
                            a.moveToLast();
                            this.f2245e = a.getLong(0);
                            String string = a.getString(a.getColumnIndex("login_name"));
                            String string2 = a.getString(a.getColumnIndex("account_detail"));
                            cursor = this.f2244c.m670a(String.format("SELECT * FROM %1$s WHERE %2$s IS '%3$s'", new Object[]{"tokens", "account_id", this.f2245e + ""}), null);
                            if (cursor.moveToLast()) {
                                String string3 = cursor.getString(cursor.getColumnIndex("tokens"));
                                try {
                                    mo831a(string, string2, C0672a.m3136b(string3));
                                } catch (Exception e3) {
                                    mo831a(string, string2, string3);
                                    m3155l();
                                }
                            } else {
                                mo831a(string, string2, "");
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

    /* renamed from: l */
    protected void m3155l() {
        Cursor cursor = null;
        synchronized (this.f2243b) {
            if (this.f2245e < 0) {
                try {
                    cursor = this.f2243b.m670a(String.format("SELECT * FROM %1$s WHERE lower(%2$s) IS lower('%3$s') AND %4$s IS '%5$s'", new Object[]{"accounts", "login_name", mo833c(), "account_type", mo835e().name()}), null);
                    if (!(cursor == null || cursor.isAfterLast())) {
                        cursor.moveToLast();
                        this.f2245e = cursor.getLong(0);
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
            if (this.f2245e < 0) {
                mo843n();
                return;
            }
            this.f2243b.m677b();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("account_type", mo835e().name());
                contentValues.put("account_detail", mo836f().toString());
                contentValues.put("login_name", mo833c());
                this.f2243b.m666a("accounts", contentValues, "account_id = " + this.f2245e, null);
                this.f2243b.m681f();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
            this.f2244c.m677b();
            try {
                contentValues = new ContentValues();
                contentValues.put("account_id", Long.valueOf(this.f2245e));
                contentValues.put("tokens", C0672a.m3132a(mo842m()));
                if (this.f2244c.m666a("tokens", contentValues, "account_id=" + this.f2245e, null) <= 0) {
                    this.f2244c.m668a("tokens", null, contentValues);
                }
                this.f2244c.m681f();
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            } finally {
                this.f2244c.m678c();
            }
        }
        this.f2243b.m678c();
    }

    /* renamed from: n */
    private void mo843n() {
        if (f2241d || this.f2245e < 0) {
            synchronized (this.f2243b) {
                ContentValues contentValues;
                this.f2243b.m677b();
                try {
                    contentValues = new ContentValues();
                    contentValues.put("account_type", mo835e().name());
                    contentValues.put("account_detail", mo836f().toString());
                    contentValues.put("login_name", mo833c());
                    this.f2245e = this.f2243b.m668a("accounts", null, contentValues);
                    this.f2243b.m681f();
                    this.f2243b.m678c();
                } catch (Exception e) {
                    e.printStackTrace();
                    this.f2243b.m678c();
                } catch (Throwable th) {
                    this.f2243b.m678c();
                }
                this.f2244c.m677b();
                try {
                    contentValues = new ContentValues();
                    contentValues.put("account_id", Long.valueOf(this.f2245e));
                    contentValues.put("tokens", C0672a.m3132a(mo842m()));
                    this.f2244c.m668a("tokens", null, contentValues);
                    this.f2244c.m681f();
                } catch (Exception e2) {
                    e2.printStackTrace();
                } finally {
                    this.f2244c.m678c();
                }
            }
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static String m3132a(String str) {
        return C0672a.m3133a(C0672a.m3135a(C0672a.mo848r(), str.getBytes()));
    }

    /* renamed from: b */
    public static String m3136b(String str) {
        return new String(C0672a.m3137b(C0672a.mo848r(), C0672a.m3138c(str)));
    }

    /* renamed from: r */
    private static byte[] mo848r() {
        return new SecretKeySpec(Arrays.copyOf(MessageDigest.getInstance("SHA-1").digest(ReaderEnv.get().getDeviceId().getBytes(HTTP.UTF_8)), 16), "AES").getEncoded();
    }

    /* renamed from: a */
    private static byte[] m3135a(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES");
        instance.init(1, secretKeySpec);
        return instance.doFinal(bArr2);
    }

    /* renamed from: b */
    private static byte[] m3137b(byte[] bArr, byte[] bArr2) {
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES");
        instance.init(2, secretKeySpec);
        return instance.doFinal(bArr2);
    }

    /* renamed from: c */
    public static byte[] m3138c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = Integer.valueOf(str.substring(i * 2, (i * 2) + 2), 16).byteValue();
        }
        return bArr;
    }

    /* renamed from: a */
    public static String m3133a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte a : bArr) {
            C0672a.m3134a(stringBuffer, a);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static void m3134a(StringBuffer stringBuffer, byte b) {
        stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15)).append("0123456789ABCDEF".charAt(b & 15));
    }
}
