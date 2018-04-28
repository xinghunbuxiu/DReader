package com.duokan.reader.domain.account;

import android.app.Activity;
import android.content.ContentValues;
import android.text.TextUtils;
import com.duokan.core.sys.C0366o;
import com.duokan.core.sys.p025a.C0345c;
import com.duokan.reader.ReaderEnv;
import com.xiaomi.micloudsdk.request.Request.RequestEnv;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnonymousAccount extends C0672a {
    /* renamed from: e */
    private String f2246e;
    /* renamed from: f */
    private final Set<String> f2247f;

    private AnonymousAccount(C0706e c0706e) {
        super(c0706e);
        this.f2246e = null;
        this.f2247f = new HashSet();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: k */
    protected void mo841k() {
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
        r0 = r1.m670a(r2, r3);	 Catch:{ Throwable -> 0x003c, all -> 0x0043 }
        r1 = r0.moveToLast();	 Catch:{ Throwable -> 0x003c, all -> 0x004d }
        if (r1 == 0) goto L_0x0036;
    L_0x0026:
        r1 = "tokens";
        r1 = r0.getColumnIndex(r1);	 Catch:{ Throwable -> 0x003c, all -> 0x004d }
        r1 = r0.getString(r1);	 Catch:{ Throwable -> 0x003c, all -> 0x004d }
        r1 = com.duokan.reader.domain.account.C0672a.m3136b(r1);	 Catch:{ Throwable -> 0x003c, all -> 0x004d }
        r7.f2246e = r1;	 Catch:{ Throwable -> 0x003c, all -> 0x004d }
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

    /* renamed from: b */
    public String mo832b() {
        String str = null;
        if (TextUtils.isEmpty(this.f2246e)) {
            Object a;
            String str2;
            try {
                a = C0345c.m830a();
            } catch (Throwable th) {
                a = null;
            }
            if (TextUtils.isEmpty(a)) {
                str2 = "";
            } else {
                str2 = C0366o.m1034b(a, "md5");
            }
            this.f2246e = str2;
            if (!TextUtils.isEmpty(this.f2246e)) {
                this.c.m677b();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("account_id", Long.valueOf(-2));
                    contentValues.put("tokens", C0672a.m3132a(this.f2246e));
                    this.c.m668a("tokens", null, contentValues);
                    this.c.m681f();
                } catch (Throwable th2) {
                } finally {
                    str = this.c;
                    str.m678c();
                }
            }
        }
        return TextUtils.isEmpty(this.f2246e) ? str : this.f2246e;
    }

    /* renamed from: n */
    public synchronized Set<String> mo843n() {
        Set<String> set;
        if (this.f2247f.size() > 0) {
            set = this.f2247f;
        } else {
            try {
                if (ReaderEnv.get().onMiui()) {
                    Class cls = Class.forName("miui.telephony.TelephonyManagerEx");
                    for (String b : (List) cls.getDeclaredMethod("getDeviceIdList", new Class[0]).invoke(cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]), new Object[0])) {
                        this.f2247f.add(C0366o.m1034b(b, "md5"));
                    }
                    set = this.f2247f;
                } else {
                    this.f2247f.add(C0366o.m1034b(C0345c.m830a(), "md5"));
                    set = this.f2247f;
                }
            } catch (Throwable th) {
            }
        }
        return set;
    }

    /* renamed from: c */
    public String mo833c() {
        return mo832b();
    }

    /* renamed from: d */
    public String mo834d() {
        return null;
    }

    /* renamed from: e */
    public AccountType mo835e() {
        return AccountType.ANONYMOUS;
    }

    /* renamed from: f */
    public C0705g mo836f() {
        return new C0742y(this);
    }

    /* renamed from: g */
    public Map<String, String> mo837g() {
        Map<String, String> hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        hashMap.put("en_device_hash", C0709k.m3476a().m3491a(currentTimeMillis));
        hashMap.put("en_ts", currentTimeMillis + "");
        return hashMap;
    }

    /* renamed from: h */
    public Map<String, String> mo838h() {
        return mo837g();
    }

    /* renamed from: a */
    public void mo829a(Activity activity, C0700d c0700d) {
    }

    /* renamed from: a */
    public void mo830a(C0699c c0699c) {
    }

    /* renamed from: j */
    public RequestEnv mo840j() {
        return null;
    }

    /* renamed from: a */
    protected void mo831a(String str, String str2, String str3) {
    }

    /* renamed from: m */
    protected String mo842m() {
        return null;
    }

    /* renamed from: i */
    public boolean mo839i() {
        return TextUtils.isEmpty(mo833c());
    }

    /* renamed from: o */
    public boolean mo844o() {
        return false;
    }

    /* renamed from: p */
    public boolean mo845p() {
        return false;
    }

    /* renamed from: q */
    public boolean mo846q() {
        return false;
    }
}
