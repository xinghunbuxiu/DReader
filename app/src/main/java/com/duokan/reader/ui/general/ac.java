package com.duokan.reader.ui.general;

import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

import com.duokan.core.sys.t;

class ac implements Runnable {
    Transformation a = new Transformation();
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ int e;
    final /* synthetic */ ab f;

    ac(ab abVar, int i, int i2, int i3, int i4) {
        this.f = abVar;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public void run() {
        if (!this.f.d.hasEnded() && this.f.e != this.b) {
            this.f.d.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.a);
            this.f.e = Math.round((((float) (this.b - this.c)) * this.a.getAlpha()) + ((float) this.c));
            this.f.f = Math.round((((float) (this.d - this.e)) * this.a.getAlpha()) + ((float) this.e));
            this.f.invalidateSelf();
            t.b((Runnable) this);
        } else if (this.f.g && this.c > this.b) {
            this.f.g = this.b > this.c;
            this.f.d();
            this.f.invalidateSelf();
        }
    }
}
