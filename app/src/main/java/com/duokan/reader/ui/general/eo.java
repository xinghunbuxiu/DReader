package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

class eo extends InsetDrawable {
    /* renamed from: a */
    final /* synthetic */ en f7160a;

    eo(en enVar, Drawable drawable, int i) {
        this.f7160a = enVar;
        super(drawable, i);
    }

    public void draw(Canvas canvas) {
        if ((this.f7160a.f7155a & 1) != 1) {
            super.draw(canvas);
        }
    }
}
