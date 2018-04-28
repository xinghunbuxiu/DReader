package com.duokan.reader.ui.general;

import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;

class fr extends TranslateAnimation {
    /* renamed from: a */
    final /* synthetic */ fs f7252a;
    /* renamed from: b */
    final /* synthetic */ fm f7253b;
    /* renamed from: c */
    private float f7254c = -1.0f;

    fr(fm fmVar, float f, float f2, float f3, float f4, fs fsVar) {
        this.f7253b = fmVar;
        this.f7252a = fsVar;
        super(f, f2, f3, f4);
    }

    public boolean getTransformation(long j, Transformation transformation) {
        boolean transformation2 = super.getTransformation(j, transformation);
        float[] fArr = new float[9];
        transformation.getMatrix().getValues(fArr);
        if (Float.compare(this.f7254c, fArr[2]) != 0) {
            this.f7253b.f7240a.mo1859a(this.f7252a, fArr[2] / ((float) this.f7252a.getContentView().getWidth()));
            this.f7254c = fArr[2];
        }
        return transformation2;
    }
}
