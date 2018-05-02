package com.duokan.p030d;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.duokan.d.g */
class C0405g implements FilenameFilter {
    /* renamed from: a */
    final /* synthetic */ C0404f f1359a;

    C0405g(C0404f c0404f) {
        this.f1359a = c0404f;
    }

    public boolean accept(File file, String str) {
        return str.endsWith(".pkg");
    }
}
