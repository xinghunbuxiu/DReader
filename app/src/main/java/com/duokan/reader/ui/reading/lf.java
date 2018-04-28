package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;

class lf implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Bitmap f10565a;
    /* renamed from: b */
    final /* synthetic */ le f10566b;

    lf(le leVar, Bitmap bitmap) {
        this.f10566b = leVar;
        this.f10565a = bitmap;
    }

    public void run() {
        this.f10566b.f10564a.f10551f.setImageBitmap(null);
        this.f10565a.recycle();
    }
}
