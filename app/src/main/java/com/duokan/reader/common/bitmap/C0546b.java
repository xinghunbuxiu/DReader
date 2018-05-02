package com.duokan.reader.common.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

/* renamed from: com.duokan.reader.common.bitmap.b */
final class C0546b implements C0545j {
    /* renamed from: a */
    final /* synthetic */ int f1810a;
    /* renamed from: b */
    final /* synthetic */ int f1811b;
    /* renamed from: c */
    final /* synthetic */ Config f1812c;

    C0546b(int i, int i2, Config config) {
        this.f1810a = i;
        this.f1811b = i2;
        this.f1812c = config;
    }

    /* renamed from: a */
    public Bitmap mo752a() {
        return Bitmap.createBitmap(Math.max(this.f1810a, 1), Math.max(this.f1811b, 1), this.f1812c);
    }
}
