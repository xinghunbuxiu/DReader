package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;

class li implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Bitmap f10569a;
    /* renamed from: b */
    final /* synthetic */ lh f10570b;

    li(lh lhVar, Bitmap bitmap) {
        this.f10570b = lhVar;
        this.f10569a = bitmap;
    }

    public void run() {
        this.f10570b.f10568a.f10551f.setImageBitmap(null);
        this.f10569a.recycle();
    }
}
