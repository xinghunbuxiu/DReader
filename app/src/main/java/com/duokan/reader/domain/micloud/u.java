package com.duokan.reader.domain.micloud;

import android.content.Context;
import android.util.Log;

import com.duokan.reader.common.async.work.e;
import com.duokan.reader.common.async.work.q;
import com.duokan.reader.common.c.f;
import com.duokan.reader.common.webservices.j;
import com.duokan.reader.domain.micloud.a.a;
import com.duokan.reader.domain.micloud.a.l;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;

import java.io.File;

public class u extends be {
    private int a;
    private int b;
    private int c;
    private int d;

    public u(Context context, z zVar, q qVar) {
        super(context, zVar, qVar);
    }

    protected int b(e eVar) {
        if (f.b().e()) {
            return 6;
        }
        return 3;
    }

    protected e a(ExtendedAuthToken extendedAuthToken) {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        System.currentTimeMillis();
        ((z) b()).G();
        e b = b(extendedAuthToken);
        ((z) b()).G();
        if (((z) b()).n()) {
            l();
        }
        return b;
    }

    private void k() {
        this.b = 0;
        ((z) b()).a(null);
        ((z) b()).b(0, 0);
        this.c = 0;
        this.d = 0;
        l();
    }

    private e b(ExtendedAuthToken extendedAuthToken) {
        File file = new File(((z) b()).w());
        while (((z) b()).o()) {
            if (file.exists() || ((z) b()).C()) {
                m();
                return e.a(0, true, true);
            }
            e c = c(extendedAuthToken);
            if (!c.b()) {
                return c;
            }
        }
        return e.b(-2, true, true);
    }

    private e c(ExtendedAuthToken extendedAuthToken) {
        m();
        if (((z) b()).A() == null) {
            return d(extendedAuthToken);
        }
        return e(extendedAuthToken);
    }

    private e d(ExtendedAuthToken extendedAuthToken) {
        try {
            j a = new a(((z) b()).N(), extendedAuthToken, ((z) b()).O()).a(((z) b()).y(), this.b);
            l lVar = (l) a.c;
            if (a.a()) {
                ((z) b()).a(lVar.a);
                m();
                j();
                return e.a(0, true, true);
            } else if (a.a == 50010) {
                if (lVar.b == null || this.b >= 3) {
                    return e.c(50010, true, true);
                }
                this.b++;
                if (!((z) b()).o()) {
                    return e.b(-2, true, true);
                }
                try {
                    Thread.sleep(lVar.b.a() * 1000);
                } catch (InterruptedException e) {
                }
                if (((z) b()).o()) {
                    return d(extendedAuthToken);
                }
                return e.b(-2, true, true);
            } else if (a.a == 10017) {
                return e.a(10017, a.b, false, false);
            } else {
                if (a.a == 50202) {
                    return e.a(50202, a.b, false, false);
                }
                return e.a(a.a, a.b, true, true);
            }
        } catch (Throwable e2) {
            Log.e("micloud", "", e2);
            throw e2;
        } catch (Throwable e22) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e22);
            return e.c(-10008, false, false);
        } catch (Throwable e222) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e222);
            return e.c(-40001, true, false);
        } catch (Throwable e2222) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e2222);
            return e.c(-40003, true, false);
        } catch (Throwable e22222) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e22222);
            return e.c(-40002, true, true);
        } catch (Throwable e222222) {
            com.duokan.reader.common.async.work.f.a("micloud", "", e222222);
            return e.c(ay.b(e222222), true, true);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.duokan.reader.common.async.work.e e(com.xiaomi.accountsdk.account.data.ExtendedAuthToken r13) {
        /*
        r12 = this;
        r11 = -30001; // 0xffffffffffff8acf float:NaN double:NaN;
        r10 = -2;
        r2 = 0;
        r1 = 1;
        r0 = r12.b();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (com.duokan.reader.domain.micloud.z) r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0.D();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r4 = new java.io.File;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r12.b();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (com.duokan.reader.domain.micloud.z) r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r0.x();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r4.<init>(r0);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r4.exists();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        if (r0 != 0) goto L_0x002d;
    L_0x0023:
        r0 = r4.getParentFile();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0.mkdirs();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r4.createNewFile();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
    L_0x002d:
        r0 = new cn.kuaipan.android.kss.KssMaster;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r3 = r12.a();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
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
        r12.m();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r12.j();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r6 = r4.length();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r12.b();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (com.duokan.reader.domain.micloud.z) r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r0.z();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r8 = r0.j();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 == 0) goto L_0x0093;
    L_0x0069:
        r6 = r4.length();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r12.b();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (com.duokan.reader.domain.micloud.z) r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r0.z();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r8 = r0.j();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x0082;
    L_0x007f:
        r4.delete();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
    L_0x0082:
        r3 = -30001; // 0xffffffffffff8acf float:NaN double:NaN;
        r4 = 1;
        r0 = r12.p();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        if (r0 != 0) goto L_0x0091;
    L_0x008b:
        r0 = r1;
    L_0x008c:
        r0 = com.duokan.reader.common.async.work.e.c(r3, r4, r0);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
    L_0x0090:
        return r0;
    L_0x0091:
        r0 = r2;
        goto L_0x008c;
    L_0x0093:
        r5 = new java.io.File;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r12.b();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (com.duokan.reader.domain.micloud.z) r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r0.w();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r5.<init>(r0);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = -1;
    L_0x00a3:
        r3 = r12.d;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r6 = 3;
        if (r3 > r6) goto L_0x0267;
    L_0x00a8:
        r0 = r4.renameTo(r5);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        if (r0 == 0) goto L_0x00c9;
    L_0x00ae:
        r0 = r12.b();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (com.duokan.reader.domain.micloud.z) r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0.H();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r12.m();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r12.j();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r3 = r2;
    L_0x00be:
        r0 = -10004; // 0xffffffffffffd8ec float:NaN double:NaN;
        if (r3 != r0) goto L_0x011c;
    L_0x00c2:
        r0 = 0;
        r4 = 0;
        r0 = com.duokan.reader.common.async.work.e.c(r3, r0, r4);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        goto L_0x0090;
    L_0x00c9:
        r0 = r5.exists();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        if (r0 != 0) goto L_0x0109;
    L_0x00cf:
        r3 = -10003; // 0xffffffffffffd8ed float:NaN double:NaN;
        r0 = r12.d;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r0 + 1;
        r12.d = r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r12.b();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (com.duokan.reader.domain.micloud.z) r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r0.o();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        if (r0 != 0) goto L_0x00eb;
    L_0x00e3:
        r0 = -2;
        r3 = 1;
        r4 = 1;
        r0 = com.duokan.reader.common.async.work.e.b(r0, r3, r4);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        goto L_0x0090;
    L_0x00eb:
        r0 = r12.d;	 Catch:{ InterruptedException -> 0x0264, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r0 * 20;
        r0 = r0 * 1000;
        r6 = (long) r0;	 Catch:{ InterruptedException -> 0x0264, KscException -> 0x0157, Exception -> 0x024c }
        java.lang.Thread.sleep(r6);	 Catch:{ InterruptedException -> 0x0264, KscException -> 0x0157, Exception -> 0x024c }
    L_0x00f5:
        r0 = r12.b();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (com.duokan.reader.domain.micloud.z) r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = r0.o();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        if (r0 != 0) goto L_0x011a;
    L_0x0101:
        r0 = -2;
        r3 = 1;
        r4 = 1;
        r0 = com.duokan.reader.common.async.work.e.b(r0, r3, r4);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        goto L_0x0090;
    L_0x0109:
        r0 = r12.b();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0 = (com.duokan.reader.domain.micloud.z) r0;	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r0.H();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r12.m();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r12.j();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        r3 = r2;
        goto L_0x00be;
    L_0x011a:
        r0 = r3;
        goto L_0x00a3;
    L_0x011c:
        if (r3 == 0) goto L_0x012e;
    L_0x011e:
        r4 = 1;
        r0 = r12.p();	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        if (r0 != 0) goto L_0x012c;
    L_0x0125:
        r0 = r1;
    L_0x0126:
        r0 = com.duokan.reader.common.async.work.e.c(r3, r4, r0);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        goto L_0x0090;
    L_0x012c:
        r0 = r2;
        goto L_0x0126;
    L_0x012e:
        r0 = 0;
        r3 = 1;
        r4 = 1;
        r0 = com.duokan.reader.common.async.work.e.a(r0, r3, r4);	 Catch:{ InterruptedException -> 0x0137, KscException -> 0x0157, Exception -> 0x024c }
        goto L_0x0090;
    L_0x0137:
        r0 = move-exception;
        r3 = "micloud";
        r4 = "";
        com.duokan.reader.common.async.work.f.a(r3, r4, r0);
        r0 = r12.b();
        r0 = (com.duokan.reader.domain.micloud.z) r0;
        r0 = r0.o();
        if (r0 != 0) goto L_0x0151;
    L_0x014b:
        r0 = com.duokan.reader.common.async.work.e.b(r10, r1, r1);
        goto L_0x0090;
    L_0x0151:
        r0 = com.duokan.reader.common.async.work.e.a(r2, r1, r1);
        goto L_0x0090;
    L_0x0157:
        r0 = move-exception;
        r3 = "micloud";
        r4 = "";
        com.duokan.reader.common.async.work.f.a(r3, r4, r0);
        r3 = r12.a();
        r3 = com.duokan.reader.domain.micloud.ay.a(r3, r0);
        r0 = -30010; // 0xffffffffffff8ac6 float:NaN double:NaN;
        if (r3 != r0) goto L_0x017a;
    L_0x016b:
        r0 = r12.p();
        if (r0 != 0) goto L_0x0178;
    L_0x0171:
        r0 = r1;
    L_0x0172:
        r0 = com.duokan.reader.common.async.work.e.c(r3, r1, r0);
        goto L_0x0090;
    L_0x0178:
        r0 = r2;
        goto L_0x0172;
    L_0x017a:
        r0 = -30003; // 0xffffffffffff8acd float:NaN double:NaN;
        if (r3 != r0) goto L_0x01dc;
    L_0x017e:
        r0 = r12.p();
        if (r0 != 0) goto L_0x01cf;
    L_0x0184:
        r0 = r12.c;
        r4 = 3;
        if (r0 >= r4) goto L_0x01cf;
    L_0x0189:
        r0 = r12.c;
        r0 = r0 + 1;
        r12.c = r0;
        r0 = r12.b();
        r0 = (com.duokan.reader.domain.micloud.z) r0;
        r0 = r0.o();
        if (r0 != 0) goto L_0x01a1;
    L_0x019b:
        r0 = com.duokan.reader.common.async.work.e.b(r10, r1, r1);
        goto L_0x0090;
    L_0x01a1:
        r0 = r12.c;	 Catch:{ InterruptedException -> 0x0261 }
        r0 = r0 * 20;
        r0 = r0 * 1000;
        r4 = (long) r0;	 Catch:{ InterruptedException -> 0x0261 }
        java.lang.Thread.sleep(r4);	 Catch:{ InterruptedException -> 0x0261 }
    L_0x01ab:
        r0 = r12.b();
        r0 = (com.duokan.reader.domain.micloud.z) r0;
        r0 = r0.o();
        if (r0 != 0) goto L_0x01bd;
    L_0x01b7:
        r0 = com.duokan.reader.common.async.work.e.b(r10, r1, r1);
        goto L_0x0090;
    L_0x01bd:
        r0 = r12.p();
        if (r0 == 0) goto L_0x01c9;
    L_0x01c3:
        r0 = com.duokan.reader.common.async.work.e.c(r3, r1, r2);
        goto L_0x0090;
    L_0x01c9:
        r0 = r12.e(r13);
        goto L_0x0090;
    L_0x01cf:
        r0 = r12.p();
        if (r0 != 0) goto L_0x01d6;
    L_0x01d5:
        r2 = r1;
    L_0x01d6:
        r0 = com.duokan.reader.common.async.work.e.c(r3, r1, r2);
        goto L_0x0090;
    L_0x01dc:
        r0 = -30004; // 0xffffffffffff8acc float:NaN double:NaN;
        if (r3 != r0) goto L_0x020f;
    L_0x01e0:
        r12.k();
        r12.m();
        r12.j();
        r0 = r12.p();
        if (r0 != 0) goto L_0x0200;
    L_0x01ef:
        r0 = r12.a;
        r3 = 3;
        if (r0 >= r3) goto L_0x0200;
    L_0x01f4:
        r0 = r12.a;
        r0 = r0 + 1;
        r12.a = r0;
        r0 = com.duokan.reader.common.async.work.e.a(r2, r1, r1);
        goto L_0x0090;
    L_0x0200:
        r0 = -30004; // 0xffffffffffff8acc float:NaN double:NaN;
        r3 = r12.p();
        if (r3 != 0) goto L_0x0209;
    L_0x0208:
        r2 = r1;
    L_0x0209:
        r0 = com.duokan.reader.common.async.work.e.c(r0, r1, r2);
        goto L_0x0090;
    L_0x020f:
        r0 = -30011; // 0xffffffffffff8ac5 float:NaN double:NaN;
        if (r3 != r0) goto L_0x0219;
    L_0x0213:
        r0 = com.duokan.reader.common.async.work.e.c(r3, r2, r2);
        goto L_0x0090;
    L_0x0219:
        r0 = -30007; // 0xffffffffffff8ac9 float:NaN double:NaN;
        if (r3 != r0) goto L_0x0223;
    L_0x021d:
        r0 = com.duokan.reader.common.async.work.e.c(r3, r1, r2);
        goto L_0x0090;
    L_0x0223:
        r0 = -30008; // 0xffffffffffff8ac8 float:NaN double:NaN;
        if (r3 != r0) goto L_0x022d;
    L_0x0227:
        r0 = com.duokan.reader.common.async.work.e.c(r3, r2, r2);
        goto L_0x0090;
    L_0x022d:
        r0 = r12.b();
        r0 = (com.duokan.reader.domain.micloud.z) r0;
        r0 = r0.o();
        if (r0 != 0) goto L_0x023f;
    L_0x0239:
        r0 = com.duokan.reader.common.async.work.e.b(r10, r1, r1);
        goto L_0x0090;
    L_0x023f:
        r0 = r12.p();
        if (r0 != 0) goto L_0x0246;
    L_0x0245:
        r2 = r1;
    L_0x0246:
        r0 = com.duokan.reader.common.async.work.e.c(r11, r1, r2);
        goto L_0x0090;
    L_0x024c:
        r0 = move-exception;
        r3 = "micloud";
        r4 = "";
        com.duokan.reader.common.async.work.f.a(r3, r4, r0);
        r0 = r12.p();
        if (r0 != 0) goto L_0x025b;
    L_0x025a:
        r2 = r1;
    L_0x025b:
        r0 = com.duokan.reader.common.async.work.e.c(r11, r1, r2);
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

    protected void f() {
        Thread.currentThread().interrupt();
        super.f();
    }

    protected void h() {
        Thread.currentThread().interrupt();
        l();
        super.h();
    }

    private void l() {
        try {
            new File(((z) b()).x()).delete();
            new File(((z) b()).w()).delete();
        } catch (Exception e) {
        }
    }

    private void m() {
        a(n(), o());
    }

    private long n() {
        if (((z) b()).C()) {
            return o();
        }
        if (((z) b()).z() == null) {
            return 0;
        }
        long j = ((z) b()).z().j();
        long B = ((z) b()).B();
        if (((z) b()).A() == null) {
            return 0;
        }
        return B < j ? B : j;
    }

    private long o() {
        if (((z) b()).z() == null) {
            return 0;
        }
        return ((z) b()).z().j();
    }

    private boolean p() {
        return f.b().c();
    }
}
