package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;

import com.duokan.core.sys.ag;

class mf implements ag {
    final /* synthetic */ me a;

    mf(me meVar) {
        this.a = meVar;
    }

    public void a(Bitmap bitmap) {
        if (this.a.getWindowToken() != null) {
            this.a.b = bitmap;
            this.a.invalidate();
        } else if (bitmap != null) {
            bitmap.recycle();
        }
    }
}
