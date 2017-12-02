package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;

class ky implements Runnable {
    final /* synthetic */ Bitmap a;
    final /* synthetic */ kx b;

    ky(kx kxVar, Bitmap bitmap) {
        this.b = kxVar;
        this.a = bitmap;
    }

    public void run() {
        this.b.a.f.setImageBitmap(null);
        this.a.recycle();
    }
}
