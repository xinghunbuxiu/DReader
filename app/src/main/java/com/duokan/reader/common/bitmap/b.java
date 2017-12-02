package com.duokan.reader.common.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

final class b implements j {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ Config c;

    b(int i, int i2, Config config) {
        this.a = i;
        this.b = i2;
        this.c = config;
    }

    public Bitmap a() {
        return Bitmap.createBitmap(Math.max(this.a, 1), Math.max(this.b, 1), this.c);
    }
}
