package com.duokan.reader.common.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;

/* renamed from: com.duokan.reader.common.bitmap.c */
final class C0547c implements C0545j {
    /* renamed from: a */
    final /* synthetic */ Options f1813a;
    /* renamed from: b */
    final /* synthetic */ byte[] f1814b;
    /* renamed from: c */
    final /* synthetic */ int f1815c;
    /* renamed from: d */
    final /* synthetic */ int f1816d;

    C0547c(Options options, byte[] bArr, int i, int i2) {
        this.f1813a = options;
        this.f1814b = bArr;
        this.f1815c = i;
        this.f1816d = i2;
    }

    @TargetApi(11)
    /* renamed from: a */
    public Bitmap mo752a() {
        if (VERSION.SDK_INT >= 16 && this.f1813a != null && this.f1813a.inBitmap != null) {
            return BitmapFactory.decodeByteArray(this.f1814b, this.f1815c, this.f1816d, this.f1813a);
        }
        if (VERSION.SDK_INT >= 11 && this.f1813a != null) {
            this.f1813a.inBitmap = null;
        }
        return BitmapFactory.decodeByteArray(this.f1814b, this.f1815c, this.f1816d, this.f1813a);
    }
}
