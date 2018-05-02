package com.duokan.reader.common.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

final class g implements j {
    final /* synthetic */ Context a;
    final /* synthetic */ int b;
    final /* synthetic */ Options c;

    g(Context context, int i, Options options) {
        this.a = context;
        this.b = i;
        this.c = options;
    }

    public Bitmap a() {
        return BitmapFactory.decodeResource(this.a.getResources(), this.b, this.c);
    }
}
