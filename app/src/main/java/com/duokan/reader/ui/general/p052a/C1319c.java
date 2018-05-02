package com.duokan.reader.ui.general.p052a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: com.duokan.reader.ui.general.a.c */
final class C1319c extends Animation {
    /* renamed from: a */
    final /* synthetic */ View f6892a;
    /* renamed from: b */
    final /* synthetic */ int f6893b;
    /* renamed from: c */
    final /* synthetic */ int f6894c;

    C1319c(View view, int i, int i2) {
        this.f6892a = view;
        this.f6893b = i;
        this.f6894c = i2;
    }

    protected void applyTransformation(float f, Transformation transformation) {
        this.f6892a.getLayoutParams().width = f == 1.0f ? this.f6893b : (int) (((float) this.f6894c) + (((float) (this.f6893b - this.f6894c)) * f));
        this.f6892a.requestLayout();
    }

    public boolean willChangeBounds() {
        return true;
    }
}
