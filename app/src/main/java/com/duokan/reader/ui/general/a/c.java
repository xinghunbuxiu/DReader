package com.duokan.reader.ui.general.a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

final class c extends Animation {
    final /* synthetic */ View a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;

    c(View view, int i, int i2) {
        this.a = view;
        this.b = i;
        this.c = i2;
    }

    protected void applyTransformation(float f, Transformation transformation) {
        this.a.getLayoutParams().width = f == 1.0f ? this.b : (int) (((float) this.c) + (((float) (this.b - this.c)) * f));
        this.a.requestLayout();
    }

    public boolean willChangeBounds() {
        return true;
    }
}
