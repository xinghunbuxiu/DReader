package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;

class kv implements Runnable {
    final /* synthetic */ Bitmap a;
    final /* synthetic */ ku b;

    kv(ku kuVar, Bitmap bitmap) {
        this.b = kuVar;
        this.a = bitmap;
    }

    public void run() {
        this.b.a.f.setImageBitmap(null);
        this.a.recycle();
    }
}
