package com.duokan.core.ui;

import android.graphics.Rect;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Transformation;

class bs extends AlphaAnimation {
    /* renamed from: a */
    public View f1030a = null;
    /* renamed from: b */
    public View f1031b = null;
    /* renamed from: c */
    final /* synthetic */ bk f1032c;

    public bs(bk bkVar) {
        this.f1032c = bkVar;
        super(0.0f, 1.0f);
        setDuration(200);
        initialize(0, 0, 0, 0);
    }

    /* renamed from: a */
    public void m1699a(Rect rect, long j) {
        Transformation transformation = (Transformation) dv.f1194c.addAnimation();
        Rect rect2 = (Rect) dv.f1198g.addAnimation();
        Rect rect3 = (Rect) dv.f1198g.addAnimation();
        getTransformation(j, transformation);
        if (this.f1031b == null || this.f1031b.getParent() != this.f1032c) {
            rect.setEmpty();
        } else if (this.f1030a == null || this.f1030a.getParent() != this.f1032c) {
            this.f1032c.m1682a(rect, this.f1031b);
        } else {
            this.f1032c.m1682a(rect2, this.f1030a);
            this.f1032c.m1682a(rect3, this.f1031b);
            rect.left = Math.round(((float) rect2.left) + (((float) (rect3.left - rect2.left)) * transformation.getAlpha()));
            rect.top = Math.round(((float) rect2.top) + (((float) (rect3.top - rect2.top)) * transformation.getAlpha()));
            rect.right = Math.round(((float) rect2.right) + (((float) (rect3.right - rect2.right)) * transformation.getAlpha()));
            rect.bottom = Math.round(((float) rect2.bottom) + (((float) (rect3.bottom - rect2.bottom)) * transformation.getAlpha()));
        }
        dv.f1194c.clearAnimation(transformation);
        dv.f1198g.clearAnimation(rect2);
        dv.f1198g.clearAnimation(rect3);
    }
}
