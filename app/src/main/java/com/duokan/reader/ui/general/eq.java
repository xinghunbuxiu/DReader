package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

class eq extends InsetDrawable {
    final /* synthetic */ ep a;

    eq(ep epVar, Drawable drawable, int i) {
        this.a = epVar;
        super(drawable, i);
    }

    public void draw(Canvas canvas) {
        if ((this.a.a & 1) != 1) {
            super.draw(canvas);
        }
    }
}
