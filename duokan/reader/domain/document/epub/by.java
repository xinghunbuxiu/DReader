package com.duokan.reader.domain.document.epub;

import android.graphics.Bitmap;

class by implements Runnable {
    final /* synthetic */ Bitmap a;
    final /* synthetic */ bx b;

    by(bx bxVar, Bitmap bitmap) {
        this.b = bxVar;
        this.a = bitmap;
    }

    public void run() {
        if (this.b.a != null) {
            this.b.a.a(this.a);
        }
    }
}
