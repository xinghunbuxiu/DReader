package com.duokan.core.ui;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

class p extends InsetDrawable {
    final /* synthetic */ ExtendView a;

    p(ExtendView extendView, Drawable drawable, int i) {
        this.a = extendView;
        super(drawable, i);
    }

    public void draw(Canvas canvas) {
        this.a.a.setBounds(this.a.b);
        this.a.a.draw(canvas);
    }
}
