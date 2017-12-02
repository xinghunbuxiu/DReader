package com.duokan.reader.ui.general;

import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;

class fx extends TranslateAnimation {
    final /* synthetic */ fy a;
    final /* synthetic */ fs b;
    private float c = -1.0f;

    fx(fs fsVar, float f, float f2, float f3, float f4, fy fyVar) {
        this.b = fsVar;
        this.a = fyVar;
        super(f, f2, f3, f4);
    }

    public boolean getTransformation(long j, Transformation transformation) {
        boolean transformation2 = super.getTransformation(j, transformation);
        float[] fArr = new float[9];
        transformation.getMatrix().getValues(fArr);
        if (Float.compare(this.c, fArr[2]) != 0) {
            this.b.a.a(this.a, fArr[2] / ((float) this.a.getContentView().getWidth()));
            this.c = fArr[2];
        }
        return transformation2;
    }
}
