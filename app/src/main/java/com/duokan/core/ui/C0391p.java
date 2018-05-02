package com.duokan.core.ui;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

/* renamed from: com.duokan.core.ui.p */
class C0391p extends InsetDrawable {
    /* renamed from: a */
    final /* synthetic */ ExtendView f1330a;

    C0391p(ExtendView extendView, Drawable drawable, int i) {
        this.f1330a = extendView;
        super(drawable, i);
    }

    public void draw(Canvas canvas) {
        this.f1330a.f749a.setBounds(this.f1330a.f750b);
        this.f1330a.f749a.draw(canvas);
    }
}
