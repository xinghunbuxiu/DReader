package com.duokan.reader.common.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

import java.io.InputStream;

final class f implements j {
    final /* synthetic */ InputStream a;
    final /* synthetic */ Options b;

    f(InputStream inputStream, Options options) {
        this.a = inputStream;
        this.b = options;
    }

    public Bitmap a() {
        return BitmapFactory.decodeStream(this.a, null, this.b);
    }
}
