package com.duokan.reader.domain.account;

import android.net.Uri;
import com.duokan.core.p026a.C0285n;
import com.duokan.reader.ReaderEnv;
import java.io.File;

public class ci {
    /* renamed from: a */
    private static C0285n f2465a = null;

    /* renamed from: a */
    public static C0285n m3438a() {
        if (f2465a == null) {
            f2465a = new C0285n(Uri.fromFile(new File(ReaderEnv.get().getDatabaseDirectory(), "Token.db")).toString());
            m3440a(f2465a);
        }
        return f2465a;
    }

    /* renamed from: a */
    private static boolean m3440a(C0285n c0285n) {
        int d = c0285n.m679d();
        if (d >= 1) {
            return true;
        }
        c0285n.m672a(1);
        if (d != 0) {
            return true;
        }
        c0285n.m677b();
        try {
            m3439a(c0285n, d);
            c0285n.m681f();
            c0285n.m678c();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            c0285n.m678c();
            return false;
        } catch (Throwable th) {
            c0285n.m678c();
            throw th;
        }
    }

    /* renamed from: a */
    private static void m3439a(C0285n c0285n, int i) {
        if (i == 0) {
            m3441b(c0285n);
        }
    }

    /* renamed from: b */
    private static void m3441b(C0285n c0285n) {
        c0285n.m673a(String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT)", new Object[]{"tokens", "account_id", "tokens"}));
    }
}
