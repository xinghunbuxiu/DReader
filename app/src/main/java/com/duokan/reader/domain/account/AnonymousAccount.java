package com.duokan.reader.domain.account;

import android.app.Activity;
import android.content.ContentValues;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.duokan.core.a.n;
import com.duokan.core.sys.o;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.xiaomi.micloudsdk.request.Request.RequestEnv;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnonymousAccount extends a {
    private String e = null;
    private final Set f = new HashSet();

    public AnonymousAccount(e eVar) {
        super(eVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void k() {
        /*
        r7 = this;
        r0 = 0;
        r1 = r7.c;	 Catch:{ Throwable -> 0x003c, all -> 0x0043 }
        r2 = "SELECT * FROM %1$s WHERE %2$s IS '%3$s'";
        r3 = 3;
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x003c, all -> 0x0043 }
        r4 = 0;
        r5 = "tokens";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x003c, all -> 0x0043 }
        r4 = 1;
        r5 = "account_id";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x003c, all -> 0x0043 }
        r4 = 2;
        r5 = "-2";
        r3[r4] = r5;	 Catch:{ Throwable -> 0x003c, all -> 0x0043 }
        r2 = java.lang.String.format(r2, r3);	 Catch:{ Throwable -> 0x003c, all -> 0x0043 }
        r3 = 0;
        r0 = r1.a(r2, r3);	 Catch:{ Throwable -> 0x003c, all -> 0x0043 }
        r1 = r0.moveToLast();	 Catch:{ Throwable -> 0x003c, all -> 0x004d }
        if (r1 == 0) goto L_0x0036;
    L_0x0026:
        r1 = "tokens";
        r1 = r0.getColumnIndex(r1);	 Catch:{ Throwable -> 0x003c, all -> 0x004d }
        r1 = r0.getString(r1);	 Catch:{ Throwable -> 0x003c, all -> 0x004d }
        r1 = com.duokan.reader.domain.account.a.b(r1);	 Catch:{ Throwable -> 0x003c, all -> 0x004d }
        r7.e = r1;	 Catch:{ Throwable -> 0x003c, all -> 0x004d }
    L_0x0036:
        if (r0 == 0) goto L_0x003b;
    L_0x0038:
        r0.close();
    L_0x003b:
        return;
    L_0x003c:
        r1 = move-exception;
        if (r0 == 0) goto L_0x003b;
    L_0x003f:
        r0.close();
        goto L_0x003b;
    L_0x0043:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x0047:
        if (r1 == 0) goto L_0x004c;
    L_0x0049:
        r1.close();
    L_0x004c:
        throw r0;
    L_0x004d:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x0047;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.account.AnonymousAccount.k():void");
    }

    public String b() {
        n nVar = null;
        if (TextUtils.isEmpty(this.e)) {
            String str;
            Object n = n();
            if (TextUtils.isEmpty(n)) {
                str = "";
            } else {
                str = o.b(n, "md5");
            }
            this.e = str;
            if (!TextUtils.isEmpty(this.e)) {
                this.c.b();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("account_id", Long.valueOf(-2));
                    contentValues.put("tokens", a.a(this.e));
                    this.c.a("tokens", null, contentValues);
                    this.c.f();
                } catch (Throwable th) {
                } finally {
                    nVar = this.c;
                    nVar.c();
                }
            }
        }
        if (TextUtils.isEmpty(this.e)) {
            return nVar;
        }
        return this.e;
    }

    public static String n() {
        String str;
        if (ReaderEnv.get().onMiui()) {
            try {
                Class cls = Class.forName("miui.telephony.TelephonyManagerEx");
                str = (String) cls.getDeclaredMethod("getMiuiDeviceId", new Class[0]).invoke(cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]), new Object[0]);
            } catch (Throwable th) {
                str = null;
            }
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return ((TelephonyManager) DkApp.get().getSystemService("phone")).getDeviceId();
        }
        return str;
    }

    public synchronized Set o() {
        Set set;
        if (this.f.size() > 0) {
            set = this.f;
        } else {
            try {
                if (ReaderEnv.get().onMiui()) {
                    Class cls = Class.forName("miui.telephony.TelephonyManagerEx");
                    for (String b : (List) cls.getDeclaredMethod("getDeviceIdList", new Class[0]).invoke(cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]), new Object[0])) {
                        this.f.add(o.b(b, "md5"));
                    }
                    set = this.f;
                } else {
                    this.f.add(o.b(((TelephonyManager) DkApp.get().getSystemService("phone")).getDeviceId(), "md5"));
                    set = this.f;
                }
            } catch (Throwable th) {
            }
        }
        return set;
    }

    public String c() {
        return b();
    }

    public String d() {
        return null;
    }

    public AccountType e() {
        return AccountType.ANONYMOUS;
    }

    public g f() {
        return new v(this);
    }

    public Map g() {
        Map hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        hashMap.put("en_device_hash", i.f().a(currentTimeMillis));
        hashMap.put("en_ts", currentTimeMillis + "");
        return hashMap;
    }

    public Map h() {
        return g();
    }

    public void a(Activity activity, d dVar) {
    }

    public void a(c cVar) {
    }

    public RequestEnv j() {
        return null;
    }

    protected void a(String str, String str2, String str3) {
    }

    protected String m() {
        return null;
    }

    public boolean i() {
        return TextUtils.isEmpty(c());
    }

    public boolean p() {
        return false;
    }

    public boolean q() {
        return false;
    }

    public boolean r() {
        return false;
    }
}
