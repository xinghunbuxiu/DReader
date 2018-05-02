package com.duokan.reader.domain.micloud;

import android.content.Context;
import android.util.Log;
import com.duokan.reader.common.async.work.C0525e;
import com.duokan.reader.common.async.work.C0526f;
import com.duokan.reader.common.async.work.C0529q;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.C0660l;
import com.duokan.reader.domain.micloud.p046a.C1044a;
import com.duokan.reader.domain.micloud.p046a.C1055l;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import java.io.File;

/* renamed from: com.duokan.reader.domain.micloud.u */
public class C1079u extends be<C1084z> {
    /* renamed from: a */
    private int f5300a;
    /* renamed from: b */
    private int f5301b;
    /* renamed from: c */
    private int f5302c;
    /* renamed from: d */
    private int f5303d;

    public C1079u(Context context, C1084z c1084z, C0529q<C1084z> c0529q) {
        super(context, c1084z, c0529q);
    }

    /* renamed from: b */
    protected int mo1492b(C0525e c0525e) {
        if (C0559f.m2476b().m2486e()) {
            return 6;
        }
        return 3;
    }

    /* renamed from: a */
    protected C0525e mo1491a(ExtendedAuthToken extendedAuthToken) {
        this.f5300a = 0;
        this.f5301b = 0;
        this.f5302c = 0;
        this.f5303d = 0;
        System.currentTimeMillis();
        ((C1084z) mo734b()).m8320G();
        C0525e b = m8297b(extendedAuthToken);
        ((C1084z) mo734b()).m8320G();
        if (((C1084z) mo734b()).m2299n()) {
            m8302l();
        }
        return b;
    }

    /* renamed from: k */
    private void m8301k() {
        this.f5301b = 0;
        ((C1084z) mo734b()).m8322a(null);
        ((C1084z) mo734b()).m8324b(0, 0);
        this.f5302c = 0;
        this.f5303d = 0;
        m8302l();
    }

    /* renamed from: b */
    private C0525e m8297b(ExtendedAuthToken extendedAuthToken) {
        File file = new File(((C1084z) mo734b()).m8326w());
        while (((C1084z) mo734b()).m2300o()) {
            if (file.exists() || ((C1084z) mo734b()).m8316C()) {
                m8303m();
                return C0525e.m2309a(0, true, true);
            }
            C0525e c = m8298c(extendedAuthToken);
            if (!c.m2313b()) {
                return c;
            }
        }
        return C0525e.m2310b(-2, true, true);
    }

    /* renamed from: c */
    private C0525e m8298c(ExtendedAuthToken extendedAuthToken) {
        m8303m();
        if (((C1084z) mo734b()).m8314A() == null) {
            return m8299d(extendedAuthToken);
        }
        return m8300e(extendedAuthToken);
    }

    /* renamed from: d */
    private C0525e m8299d(ExtendedAuthToken extendedAuthToken) {
        try {
            C0660l a = new C1044a(((C1084z) mo734b()).m8140N(), extendedAuthToken, ((C1084z) mo734b()).m8141O()).m8017a(((C1084z) mo734b()).m8328y(), this.f5301b);
            C1055l c1055l = (C1055l) a.f2216c;
            if (a.m3100a()) {
                ((C1084z) mo734b()).m8322a(c1055l.f5176a);
                m8303m();
                m2277j();
                return C0525e.m2309a(0, true, true);
            } else if (a.f2214a == 50010) {
                if (c1055l.f5177b == null || this.f5301b >= 3) {
                    return C0525e.m2311c(50010, true, true);
                }
                this.f5301b++;
                if (!((C1084z) mo734b()).m2300o()) {
                    return C0525e.m2310b(-2, true, true);
                }
                try {
                    Thread.sleep(c1055l.f5177b.m8037a() * 1000);
                } catch (InterruptedException e) {
                }
                if (((C1084z) mo734b()).m2300o()) {
                    return m8299d(extendedAuthToken);
                }
                return C0525e.m2310b(-2, true, true);
            } else if (a.f2214a == 10017) {
                return C0525e.m2308a(10017, a.f2215b, false, false);
            } else {
                if (a.f2214a == 50202) {
                    return C0525e.m2308a(50202, a.f2215b, false, false);
                }
                return C0525e.m2308a(a.f2214a, a.f2215b, true, true);
            }
        } catch (Throwable e2) {
            Log.e("micloud", "", e2);
            throw e2;
        } catch (Throwable e22) {
            C0526f.m2316a("micloud", "", e22);
            return C0525e.m2311c(-10008, false, false);
        } catch (Throwable e222) {
            C0526f.m2316a("micloud", "", e222);
            return C0525e.m2311c(-40001, true, false);
        } catch (Throwable e2222) {
            C0526f.m2316a("micloud", "", e2222);
            return C0525e.m2311c(-40003, true, false);
        } catch (Throwable e22222) {
            C0526f.m2316a("micloud", "", e22222);
            return C0525e.m2311c(-40002, true, true);
        } catch (Throwable e222222) {
            C0526f.m2316a("micloud", "", e222222);
            return C0525e.m2311c(ay.m8102b(e222222), true, true);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    private com.duokan.reader.common.async.work.C0525e m8300e(com.xiaomi.accountsdk.account.data.ExtendedAuthToken r13) {
        /*
        r12 = this;
        r11 = -30001; // 0xffffffffffff8acf float:NaN double:NaN;
        r10 = -2;
        r2 = 0;
        r1 = 1;
        r0 = r12.mo734b();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (com.duokan.reader.domain.micloud.C1084z) r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0.m8317D();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r4 = new java.io.File;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r12.mo734b();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (com.duokan.reader.domain.micloud.C1084z) r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r0.m8327x();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r4.<init>(r0);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r4.exists();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        if (r0 != 0) goto L_0x002d;
    L_0x0023:
        r0 = r4.getParentFile();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0.mkdirs();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r4.createNewFile();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
    L_0x002d:
        r0 = new cn.kuaipan.android.kss.KssMaster;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r3 = r12.m2258a();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r5 = new com.duokan.reader.domain.micloud.y;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r6 = 0;
        r5.<init>(r12, r6);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r6 = 0;
        r0.<init>(r3, r5, r6);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r3 = new com.duokan.reader.domain.micloud.x;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r5 = 0;
        r3.<init>(r12, r5);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r5 = new com.duokan.reader.domain.micloud.w;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r6 = 0;
        r5.<init>(r12, r6);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r6 = 1;
        r0.download(r3, r4, r5, r6);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r12.m8303m();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r12.m2277j();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r6 = r4.length();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r12.mo734b();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (com.duokan.reader.domain.micloud.C1084z) r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r0.m8329z();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r8 = r0.m8160j();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 == 0) goto L_0x0093;
    L_0x0069:
        r6 = r4.length();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r12.mo734b();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (com.duokan.reader.domain.micloud.C1084z) r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r0.m8329z();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r8 = r0.m8160j();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x0082;
    L_0x007f:
        r4.delete();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
    L_0x0082:
        r3 = -30001; // 0xffffffffffff8acf float:NaN double:NaN;
        r4 = 1;
        r0 = r12.m8306p();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        if (r0 != 0) goto L_0x0091;
    L_0x008b:
        r0 = r1;
    L_0x008c:
        r0 = com.duokan.reader.common.async.work.C0525e.m2311c(r3, r4, r0);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
    L_0x0090:
        return r0;
    L_0x0091:
        r0 = r2;
        goto L_0x008c;
    L_0x0093:
        r5 = new java.io.File;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r12.mo734b();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (com.duokan.reader.domain.micloud.C1084z) r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r0.m8326w();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r5.<init>(r0);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = -1;
    L_0x00a3:
        r3 = r12.f5303d;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r6 = 3;
        if (r3 > r6) goto L_0x0267;
    L_0x00a8:
        r0 = r4.renameTo(r5);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        if (r0 == 0) goto L_0x00c9;
    L_0x00ae:
        r0 = r12.mo734b();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (com.duokan.reader.domain.micloud.C1084z) r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0.m8321H();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r12.m8303m();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r12.m2277j();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r3 = r2;
    L_0x00be:
        r0 = -10004; // 0xffffffffffffd8ec float:NaN double:NaN;
        if (r3 != r0) goto L_0x011c;
    L_0x00c2:
        r0 = 0;
        r4 = 0;
        r0 = com.duokan.reader.common.async.work.C0525e.m2311c(r3, r0, r4);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        goto L_0x0090;
    L_0x00c9:
        r0 = r5.exists();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        if (r0 != 0) goto L_0x0109;
    L_0x00cf:
        r3 = -10003; // 0xffffffffffffd8ed float:NaN double:NaN;
        r0 = r12.f5303d;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r0 + 1;
        r12.f5303d = r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r12.mo734b();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (com.duokan.reader.domain.micloud.C1084z) r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r0.m2300o();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        if (r0 != 0) goto L_0x00eb;
    L_0x00e3:
        r0 = -2;
        r3 = 1;
        r4 = 1;
        r0 = com.duokan.reader.common.async.work.C0525e.m2310b(r0, r3, r4);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        goto L_0x0090;
    L_0x00eb:
        r0 = r12.f5303d;	 Catch:{ InterruptedException -> 0x0264, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r0 * 20;
        r0 = r0 * 1000;
        r6 = (long) r0;	 Catch:{ InterruptedException -> 0x0264, KscException -> 0x0157, Exception -> 0x024c }
        java.lang.Thread.sleep(r6);	 Catch:{ InterruptedException -> 0x0264, KscException -> 0x0157, Exception -> 0x024c }
    L_0x00f5:
        r0 = r12.mo734b();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (com.duokan.reader.domain.micloud.C1084z) r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r0.m2300o();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        if (r0 != 0) goto L_0x011a;
    L_0x0101:
        r0 = -2;
        r3 = 1;
        r4 = 1;
        r0 = com.duokan.reader.common.async.work.C0525e.m2310b(r0, r3, r4);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        goto L_0x0090;
    L_0x0109:
        r0 = r12.mo734b();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (com.duokan.reader.domain.micloud.C1084z) r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0.m8321H();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r12.m8303m();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r12.m2277j();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r3 = r2;
        goto L_0x00be;
    L_0x011a:
        r0 = r3;
        goto L_0x00a3;
    L_0x011c:
        if (r3 == 0) goto L_0x012e;
    L_0x011e:
        r4 = 1;
        r0 = r12.m8306p();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        if (r0 != 0) goto L_0x012c;
    L_0x0125:
        r0 = r1;
    L_0x0126:
        r0 = com.duokan.reader.common.async.work.C0525e.m2311c(r3, r4, r0);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        goto L_0x0090;
    L_0x012c:
        r0 = r2;
        goto L_0x0126;
    L_0x012e:
        r0 = 0;
        r3 = 1;
        r4 = 1;
        r0 = com.duokan.reader.common.async.work.C0525e.m2309a(r0, r3, r4);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        goto L_0x0090;
    L_0x0137:
        r0 = move-exception;
        r3 = "micloud";
        r4 = "";
        com.duokan.reader.common.async.work.C0526f.m2316a(r3, r4, r0);
        r0 = r12.mo734b();
        r0 = (com.duokan.reader.domain.micloud.C1084z) r0;
        r0 = r0.m2300o();
        if (r0 != 0) goto L_0x0151;
    L_0x014b:
        r0 = com.duokan.reader.common.async.work.C0525e.m2310b(r10, r1, r1);
        goto L_0x0090;
    L_0x0151:
        r0 = com.duokan.reader.common.async.work.C0525e.m2309a(r2, r1, r1);
        goto L_0x0090;
    L_0x0157:
        r0 = move-exception;
        r3 = "micloud";
        r4 = "";
        com.duokan.reader.common.async.work.C0526f.m2316a(r3, r4, r0);
        r3 = r12.m2258a();
        r3 = com.duokan.reader.domain.micloud.ay.m8099a(r3, r0);
        r0 = -30010; // 0xffffffffffff8ac6 float:NaN double:NaN;
        if (r3 != r0) goto L_0x017a;
    L_0x016b:
        r0 = r12.m8306p();
        if (r0 != 0) goto L_0x0178;
    L_0x0171:
        r0 = r1;
    L_0x0172:
        r0 = com.duokan.reader.common.async.work.C0525e.m2311c(r3, r1, r0);
        goto L_0x0090;
    L_0x0178:
        r0 = r2;
        goto L_0x0172;
    L_0x017a:
        r0 = -30003; // 0xffffffffffff8acd float:NaN double:NaN;
        if (r3 != r0) goto L_0x01dc;
    L_0x017e:
        r0 = r12.m8306p();
        if (r0 != 0) goto L_0x01cf;
    L_0x0184:
        r0 = r12.f5302c;
        r4 = 3;
        if (r0 >= r4) goto L_0x01cf;
    L_0x0189:
        r0 = r12.f5302c;
        r0 = r0 + 1;
        r12.f5302c = r0;
        r0 = r12.mo734b();
        r0 = (com.duokan.reader.domain.micloud.C1084z) r0;
        r0 = r0.m2300o();
        if (r0 != 0) goto L_0x01a1;
    L_0x019b:
        r0 = com.duokan.reader.common.async.work.C0525e.m2310b(r10, r1, r1);
        goto L_0x0090;
    L_0x01a1:
        r0 = r12.f5302c;	 Catch:{ InterruptedException -> 0x0261 }
        r0 = r0 * 20;
        r0 = r0 * 1000;
        r4 = (long) r0;	 Catch:{ InterruptedException -> 0x0261 }
        java.lang.Thread.sleep(r4);	 Catch:{ InterruptedException -> 0x0261 }
    L_0x01ab:
        r0 = r12.mo734b();
        r0 = (com.duokan.reader.domain.micloud.C1084z) r0;
        r0 = r0.m2300o();
        if (r0 != 0) goto L_0x01bd;
    L_0x01b7:
        r0 = com.duokan.reader.common.async.work.C0525e.m2310b(r10, r1, r1);
        goto L_0x0090;
    L_0x01bd:
        r0 = r12.m8306p();
        if (r0 == 0) goto L_0x01c9;
    L_0x01c3:
        r0 = com.duokan.reader.common.async.work.C0525e.m2311c(r3, r1, r2);
        goto L_0x0090;
    L_0x01c9:
        r0 = r12.m8300e(r13);
        goto L_0x0090;
    L_0x01cf:
        r0 = r12.m8306p();
        if (r0 != 0) goto L_0x01d6;
    L_0x01d5:
        r2 = r1;
    L_0x01d6:
        r0 = com.duokan.reader.common.async.work.C0525e.m2311c(r3, r1, r2);
        goto L_0x0090;
    L_0x01dc:
        r0 = -30004; // 0xffffffffffff8acc float:NaN double:NaN;
        if (r3 != r0) goto L_0x020f;
    L_0x01e0:
        r12.m8301k();
        r12.m8303m();
        r12.m2277j();
        r0 = r12.m8306p();
        if (r0 != 0) goto L_0x0200;
    L_0x01ef:
        r0 = r12.f5300a;
        r3 = 3;
        if (r0 >= r3) goto L_0x0200;
    L_0x01f4:
        r0 = r12.f5300a;
        r0 = r0 + 1;
        r12.f5300a = r0;
        r0 = com.duokan.reader.common.async.work.C0525e.m2309a(r2, r1, r1);
        goto L_0x0090;
    L_0x0200:
        r0 = -30004; // 0xffffffffffff8acc float:NaN double:NaN;
        r3 = r12.m8306p();
        if (r3 != 0) goto L_0x0209;
    L_0x0208:
        r2 = r1;
    L_0x0209:
        r0 = com.duokan.reader.common.async.work.C0525e.m2311c(r0, r1, r2);
        goto L_0x0090;
    L_0x020f:
        r0 = -30011; // 0xffffffffffff8ac5 float:NaN double:NaN;
        if (r3 != r0) goto L_0x0219;
    L_0x0213:
        r0 = com.duokan.reader.common.async.work.C0525e.m2311c(r3, r2, r2);
        goto L_0x0090;
    L_0x0219:
        r0 = -30007; // 0xffffffffffff8ac9 float:NaN double:NaN;
        if (r3 != r0) goto L_0x0223;
    L_0x021d:
        r0 = com.duokan.reader.common.async.work.C0525e.m2311c(r3, r1, r2);
        goto L_0x0090;
    L_0x0223:
        r0 = -30008; // 0xffffffffffff8ac8 float:NaN double:NaN;
        if (r3 != r0) goto L_0x022d;
    L_0x0227:
        r0 = com.duokan.reader.common.async.work.C0525e.m2311c(r3, r2, r2);
        goto L_0x0090;
    L_0x022d:
        r0 = r12.mo734b();
        r0 = (com.duokan.reader.domain.micloud.C1084z) r0;
        r0 = r0.m2300o();
        if (r0 != 0) goto L_0x023f;
    L_0x0239:
        r0 = com.duokan.reader.common.async.work.C0525e.m2310b(r10, r1, r1);
        goto L_0x0090;
    L_0x023f:
        r0 = r12.m8306p();
        if (r0 != 0) goto L_0x0246;
    L_0x0245:
        r2 = r1;
    L_0x0246:
        r0 = com.duokan.reader.common.async.work.C0525e.m2311c(r11, r1, r2);
        goto L_0x0090;
    L_0x024c:
        r0 = move-exception;
        r3 = "micloud";
        r4 = "";
        com.duokan.reader.common.async.work.C0526f.m2316a(r3, r4, r0);
        r0 = r12.m8306p();
        if (r0 != 0) goto L_0x025b;
    L_0x025a:
        r2 = r1;
    L_0x025b:
        r0 = com.duokan.reader.common.async.work.C0525e.m2311c(r11, r1, r2);
        goto L_0x0090;
    L_0x0261:
        r0 = move-exception;
        goto L_0x01ab;
    L_0x0264:
        r0 = move-exception;
        goto L_0x00f5;
    L_0x0267:
        r3 = r0;
        goto L_0x00be;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.micloud.u.e(com.xiaomi.accountsdk.account.data.ExtendedAuthToken):com.duokan.reader.common.async.work.e");
    }

    /* renamed from: f */
    protected void mo1493f() {
        Thread.currentThread().interrupt();
        super.mo1493f();
    }

    /* renamed from: h */
    protected void mo1494h() {
        Thread.currentThread().interrupt();
        m8302l();
        super.mo1494h();
    }

    /* renamed from: l */
    private void m8302l() {
        try {
            new File(((C1084z) mo734b()).m8327x()).delete();
            new File(((C1084z) mo734b()).m8326w()).delete();
        } catch (Exception e) {
        }
    }

    /* renamed from: m */
    private void m8303m() {
        m2261a(m8304n(), m8305o());
    }

    /* renamed from: n */
    private long m8304n() {
        if (((C1084z) mo734b()).m8316C()) {
            return m8305o();
        }
        if (((C1084z) mo734b()).m8329z() == null) {
            return 0;
        }
        long j = ((C1084z) mo734b()).m8329z().m8160j();
        long B = ((C1084z) mo734b()).m8315B();
        if (((C1084z) mo734b()).m8314A() == null) {
            return 0;
        }
        return B < j ? B : j;
    }

    /* renamed from: o */
    private long m8305o() {
        if (((C1084z) mo734b()).m8329z() == null) {
            return 0;
        }
        return ((C1084z) mo734b()).m8329z().m8160j();
    }

    /* renamed from: p */
    private boolean m8306p() {
        return C0559f.m2476b().m2484c();
    }
}
