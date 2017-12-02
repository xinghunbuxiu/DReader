package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

class er extends InsetDrawable {
    final /* synthetic */ ep a;

    er(ep epVar, Drawable drawable, int i) {
        this.a = epVar;
        super(drawable, i);
    }

    public void draw(Canvas canvas) {
        if ((this.a.a & 2) != 2) {
            super.draw(canvas);
        }
    }
}
