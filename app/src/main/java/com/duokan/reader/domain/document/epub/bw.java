package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;

class bw implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Bitmap f4614a;
    /* renamed from: b */
    final /* synthetic */ bv f4615b;

    bw(bv bvVar, Bitmap bitmap) {
        this.f4615b = bvVar;
        this.f4614a = bitmap;
    }

    public void run() {
        if (this.f4615b.f4612a != null) {
            this.f4615b.f4612a.run(this.f4614a);
        }
    }
}
