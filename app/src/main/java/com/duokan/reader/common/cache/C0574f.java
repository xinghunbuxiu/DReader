package com.duokan.reader.common.cache;

import android.net.Uri;
import com.duokan.core.p026a.C0285n;
import com.duokan.reader.ReaderEnv;
import java.io.File;

/* renamed from: com.duokan.reader.common.cache.f */
public class C0574f {
    /* renamed from: a */
    private static C0285n f1883a;

    /* renamed from: a */
    public static C0285n m2573a() {
        if (f1883a == null) {
            f1883a = new C0285n(Uri.fromFile(new File(ReaderEnv.get().getDatabaseDirectory(), "ImportantListCaches.db")).toString(), Uri.fromFile(new File(ReaderEnv.get().getExternalFilesDirectory(), "ImportantListCaches.db")).toString());
            C0574f.m2574a(f1883a);
        }
        return f1883a;
    }

    /* renamed from: a */
    private static boolean m2574a(C0285n c0285n) {
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
