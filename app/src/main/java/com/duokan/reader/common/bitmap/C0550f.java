package com.duokan.reader.common.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.io.InputStream;

/* renamed from: com.duokan.reader.common.bitmap.f */
final class C0550f implements C0545j {
    /* renamed from: a */
    final /* synthetic */ InputStream f1819a;
    /* renamed from: b */
    final /* synthetic */ Options f1820b;

    C0550f(InputStream inputStream, Options options) {
        this.f1819a = inputStream;
        this.f1820b = options;
    }

    /* renamed from: a */
    public Bitmap mo752a() {
        return BitmapFactory.decodeStream(this.f1819a, null, this.f1820b);
    }
}
