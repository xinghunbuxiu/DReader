package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;

class bw implements Runnable {
    final /* synthetic */ Bitmap a;
    final /* synthetic */ bv b;

    bw(bv bvVar, Bitmap bitmap) {
        this.b = bvVar;
        this.a = bitmap;
    }

    public void run() {
        if (this.b.a != null) {
            this.b.a.a(this.a);
        }
    }
}
