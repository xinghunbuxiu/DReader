package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;

import java.io.File;

class wn implements Runnable {
    final /* synthetic */ File a;
    final /* synthetic */ Bitmap b;
    final /* synthetic */ wl c;

    wn(wl wlVar, File file, Bitmap bitmap) {
        this.c = wlVar;
        this.a = file;
        this.b = bitmap;
    }

    public void run() {
        a.d(this.a);
        a.b(this.b, CompressFormat.PNG, 100, this.a);
        this.b.recycle();
        this.c.m();
    }
}
