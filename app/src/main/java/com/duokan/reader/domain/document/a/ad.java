package com.duokan.reader.domain.document.a;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.duokan.reader.domain.document.ap;
import com.duokan.reader.domain.document.ar;

class ad implements ar {
    final /* synthetic */ Rect a;
    final /* synthetic */ float b;
    final /* synthetic */ w c;

    ad(w wVar, Rect rect, float f) {
        this.c = wVar;
        this.a = rect;
        this.b = f;
    }

    public void a(ap apVar, Bitmap bitmap, Object obj) {
        this.c.a(bitmap, (Bitmap) obj, this.a, this.b);
        if (this.c.U()) {
            this.c.R();
        } else {
            this.c.T();
        }
    }

    public void a(ap apVar) {
        if (this.c.U()) {
            this.c.R();
        } else {
            this.c.T();
        }
    }
}
