package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.duokan.core.io.C0336a;
import java.io.File;

class xa implements Runnable {
    /* renamed from: a */
    final /* synthetic */ File f11132a;
    /* renamed from: b */
    final /* synthetic */ Bitmap f11133b;
    /* renamed from: c */
    final /* synthetic */ wy f11134c;

    xa(wy wyVar, File file, Bitmap bitmap) {
        this.f11134c = wyVar;
        this.f11132a = file;
        this.f11133b = bitmap;
    }

    public void run() {
        C0336a.m793f(this.f11132a);
        C0336a.m784b(this.f11133b, CompressFormat.PNG, 100, this.f11132a);
        this.f11133b.recycle();
        this.f11134c.m13644m();
    }
}
