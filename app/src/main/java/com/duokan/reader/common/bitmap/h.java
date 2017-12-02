package com.duokan.reader.common.bitmap;

import android.content.Context;
import android.graphics.Bitmap;

final class h implements j {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;

    h(Context context, String str, int i, int i2) {
        this.a = context;
        this.b = str;
        this.c = i;
        this.d = i2;
    }

    public Bitmap a() {
        return a.c(this.a, this.b, this.c, this.d);
    }
}
