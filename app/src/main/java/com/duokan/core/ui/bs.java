package com.duokan.core.ui;

import android.graphics.Rect;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Transformation;

class bs extends AlphaAnimation {
    public View a = null;
    public View b = null;
    final /* synthetic */ bk c;

    public bs(bk bkVar) {
        this.c = bkVar;
        super(0.0f, 1.0f);
        setDuration(200);
        initialize(0, 0, 0, 0);
    }

    public void a(Rect rect, long j) {
        Transformation transformation = (Transformation) dv.c.a();
        Rect rect2 = (Rect) dv.g.a();
        Rect rect3 = (Rect) dv.g.a();
        getTransformation(j, transformation);
        if (this.b == null || this.b.getParent() != this.c) {
            rect.setEmpty();
        } else if (this.a == null || this.a.getParent() != this.c) {
            this.c.a(rect, this.b);
        } else {
            this.c.a(rect2, this.a);
            this.c.a(rect3, this.b);
            rect.left = Math.round(((float) rect2.left) + (((float) (rect3.left - rect2.left)) * transformation.getAlpha()));
            rect.top = Math.round(((float) rect2.top) + (((float) (rect3.top - rect2.top)) * transformation.getAlpha()));
            rect.right = Math.round(((float) rect2.right) + (((float) (rect3.right - rect2.right)) * transformation.getAlpha()));
            rect.bottom = Math.round(((float) rect2.bottom) + (((float) (rect3.bottom - rect2.bottom)) * transformation.getAlpha()));
        }
        dv.c.a(transformation);
        dv.g.a(rect2);
        dv.g.a(rect3);
    }
}
