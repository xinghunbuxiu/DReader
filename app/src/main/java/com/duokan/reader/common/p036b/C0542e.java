package com.duokan.reader.common.p036b;

import android.accounts.Account;
import android.content.Context;
import com.duokan.reader.common.webservices.duokan.C0641o;

/* renamed from: com.duokan.reader.common.b.e */
public class C0542e {
    /* renamed from: a */
    public static C0538a m2411a(Context context) {
        return C0542e.m2412a(context, false);
    }

    /* renamed from: a */
    public static C0538a m2412a(Context context, boolean z) {
        if (!z) {
            C0542e.m2413b(context);
        }
        return C0538a.m2388a(context);
    }

    /* renamed from: b */
    public static void m2413b(Context context) {
        C0538a a = C0538a.m2388a(context);
        if (C0542e.m2414c(context)) {
            a.m2403c();
            if (!C0641o.m2934i().m2984k()) {
                a.m2405e();
                return;
            }
            return;
        }
        a.m2404d();
    }

    /* renamed from: c */
    private static boolean m2414c(Context context) {
        C0538a a = C0538a.m2388a(context);
        Account j = a.m2410j();
        if (j == null) {
            return false;
        }
        a.m2404d();
        Account[] a2 = a.m2401a("com.xiaomi");
        if (a2 == null || a2.length == 0) {
            return true;
        }
        return a2[0].name.equals(j.name);
    }
}
