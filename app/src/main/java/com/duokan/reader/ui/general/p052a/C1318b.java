package com.duokan.reader.ui.general.p052a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: com.duokan.reader.ui.general.a.b */
final class C1318b extends Animation {
    /* renamed from: a */
    final /* synthetic */ View f6889a;
    /* renamed from: b */
    final /* synthetic */ int f6890b;
    /* renamed from: c */
    final /* synthetic */ int f6891c;

    C1318b(View view, int i, int i2) {
        this.f6889a = view;
        this.f6890b = i;
        this.f6891c = i2;
    }

    protected void applyTransformation(float f, Transformation transformation) {
        this.f6889a.getLayoutParams().width = f == 1.0f ? this.f6890b : (int) (((float) this.f6891c) + (((float) (this.f6890b - this.f6891c)) * f));
        this.f6889a.requestLayout();
    }

    public boolean willChangeBounds() {
        return true;
    }
}
