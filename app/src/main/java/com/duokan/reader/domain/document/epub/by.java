package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;

class by implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Bitmap f4618a;
    /* renamed from: b */
    final /* synthetic */ bx f4619b;

    by(bx bxVar, Bitmap bitmap) {
        this.f4619b = bxVar;
        this.f4618a = bitmap;
    }

    public void run() {
        if (this.f4619b.f4616a != null) {
            this.f4619b.f4616a.run(this.f4618a);
        }
    }
}
