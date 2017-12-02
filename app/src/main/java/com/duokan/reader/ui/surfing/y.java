package com.duokan.reader.ui.surfing;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class y extends Animation {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ x c;

    y(x xVar, int i, int i2) {
        this.c = xVar;
        this.a = i;
        this.b = i2;
    }

    protected void applyTransformation(float f, Transformation transformation) {
        this.c.d.n.a(((int) (((float) (this.a - this.b)) * f)) + this.b);
    }
}
