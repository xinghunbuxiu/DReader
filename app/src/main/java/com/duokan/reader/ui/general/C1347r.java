package com.duokan.reader.ui.general;

import android.graphics.Bitmap;
import java.io.File;

/* renamed from: com.duokan.reader.ui.general.r */
class C1347r implements Runnable {
    /* renamed from: a */
    final /* synthetic */ File f7549a;
    /* renamed from: b */
    final /* synthetic */ Bitmap f7550b;
    /* renamed from: c */
    final /* synthetic */ C1343o f7551c;

    C1347r(C1343o c1343o, File file, Bitmap bitmap) {
        this.f7551c = c1343o;
        this.f7549a = file;
        this.f7550b = bitmap;
    }

    public void run() {
        this.f7551c.m10944a(this.f7549a, this.f7550b, null);
    }
}
