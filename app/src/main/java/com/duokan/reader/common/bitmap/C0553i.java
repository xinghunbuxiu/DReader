package com.duokan.reader.common.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* renamed from: com.duokan.reader.common.bitmap.i */
final class C0553i implements C0545j {
    /* renamed from: a */
    final /* synthetic */ String f1828a;

    C0553i(String str) {
        this.f1828a = str;
    }

    /* renamed from: a */
    public Bitmap mo752a() {
        return BitmapFactory.decodeFile(this.f1828a);
    }
}
