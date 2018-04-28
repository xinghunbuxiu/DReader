package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

class ep extends InsetDrawable {
    /* renamed from: a */
    final /* synthetic */ en f7161a;

    ep(en enVar, Drawable drawable, int i) {
        this.f7161a = enVar;
        super(drawable, i);
    }

    public void draw(Canvas canvas) {
        if ((this.f7161a.f7155a & 2) != 2) {
            super.draw(canvas);
        }
    }
}
