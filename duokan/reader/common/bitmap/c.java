package com.duokan.reader.common.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;

final class c implements j {
    final /* synthetic */ Options a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;

    c(Options options, byte[] bArr, int i, int i2) {
        this.a = options;
        this.b = bArr;
        this.c = i;
        this.d = i2;
    }

    @TargetApi(11)
    public Bitmap a() {
        if (VERSION.SDK_INT >= 16 && this.a != null && this.a.inBitmap != null) {
            return BitmapFactory.decodeByteArray(this.b, this.c, this.d, this.a);
        }
        if (VERSION.SDK_INT >= 11 && this.a != null) {
            this.a.inBitmap = null;
        }
        return BitmapFactory.decodeByteArray(this.b, this.c, this.d, this.a);
    }
}
