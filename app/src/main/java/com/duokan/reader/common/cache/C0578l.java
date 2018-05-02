package com.duokan.reader.common.cache;

import com.duokan.core.p026a.C0285n;
import com.duokan.reader.ReaderEnv;
import java.io.File;

/* renamed from: com.duokan.reader.common.cache.l */
public class C0578l {
    /* renamed from: a */
    private static C0285n f1886a;

    /* renamed from: a */
    public static C0285n m2590a() {
        if (f1886a == null) {
            f1886a = new C0285n(new File(ReaderEnv.get().getDatabaseDirectory(), "ListCacheDatabaseStore.db").getAbsolutePath(), "");
            C0578l.m2591a(f1886a);
        }
        return f1886a;
    }

    /* renamed from: a */
    private static boolean m2591a(C0285n c0285n) {
        if (c0285n.m679d() < 1) {
            try {
                c0285n.m677b();
                c0285n.m672a(1);
                c0285n.m681f();
            } finally {
                c0285n.m678c();
            }
        }
        return true;
    }
}
