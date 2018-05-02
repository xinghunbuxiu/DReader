package com.duokan.reader.common.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

/* renamed from: com.duokan.reader.common.bitmap.g */
final class C0551g implements C0545j {
    /* renamed from: a */
    final /* synthetic */ Context f1821a;
    /* renamed from: b */
    final /* synthetic */ int f1822b;
    /* renamed from: c */
    final /* synthetic */ Options f1823c;

    C0551g(Context context, int i, Options options) {
        this.f1821a = context;
        this.f1822b = i;
        this.f1823c = options;
    }

    /* renamed from: a */
    public Bitmap mo752a() {
        return BitmapFactory.decodeResource(this.f1821a.getResources(), this.f1822b, this.f1823c);
    }
}
