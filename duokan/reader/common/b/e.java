package com.duokan.reader.common.b;

import android.accounts.Account;
import android.content.Context;

import com.duokan.reader.common.webservices.duokan.p;

public class e {
    public static a a(Context context) {
        return a(context, false);
    }

    public static a a(Context context, boolean z) {
        if (!z) {
            b(context);
        }
        return a.a(context);
    }

    public static void b(Context context) {
        a a = a.a(context);
        if (c(context)) {
            a.c();
            if (!p.i().k()) {
                a.e();
                return;
            }
            return;
        }
        a.d();
    }

    private static boolean c(Context context) {
        a a = a.a(context);
        Account j = a.j();
        if (j == null) {
            return false;
        }
        a.d();
        Account[] a2 = a.a("com.xiaomi");
        if (a2 == null || a2.length == 0) {
            return true;
        }
        return a2[0].name.equals(j.name);
    }
}
