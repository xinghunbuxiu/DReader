package com.duokan.reader.ui.surfing;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class ae extends Animation {
    /* renamed from: a */
    final /* synthetic */ int f11507a;
    /* renamed from: b */
    final /* synthetic */ int f11508b;
    /* renamed from: c */
    final /* synthetic */ ad f11509c;

    ae(ad adVar, int i, int i2) {
        this.f11509c = adVar;
        this.f11507a = i;
        this.f11508b = i2;
    }

    protected void applyTransformation(float f, Transformation transformation) {
        this.f11509c.f11506d.f11549q.m15332a(((int) (((float) (this.f11507a - this.f11508b)) * f)) + this.f11508b);
    }
}
