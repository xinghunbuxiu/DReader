package com.duokan.reader.common.cache;

import com.duokan.core.a.n;
import com.duokan.reader.ReaderEnv;

import java.io.File;

public class l {
    private static n a;

    public static n a() {
        if (a == null) {
            a = new n(new File(ReaderEnv.get().getDatabaseDirectory(), "ListCacheDatabaseStore.db").getAbsolutePath(), "");
            a(a);
        }
        return a;
    }

    private static boolean a(n nVar) {
        if (nVar.d() < 1) {
            try {
                nVar.b();
                nVar.a(1);
                nVar.f();
            } finally {
                nVar.c();
            }
        }
        return true;
    }
}
