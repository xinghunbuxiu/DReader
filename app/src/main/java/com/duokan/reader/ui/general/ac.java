package com.duokan.reader.ui.general;

import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import com.duokan.core.sys.UThread;

class ac implements Runnable {
    /* renamed from: a */
    Transformation f6909a = new Transformation();
    /* renamed from: b */
    final /* synthetic */ int f6910b;
    /* renamed from: c */
    final /* synthetic */ int f6911c;
    /* renamed from: d */
    final /* synthetic */ int f6912d;
    /* renamed from: e */
    final /* synthetic */ int f6913e;
    /* renamed from: f */
    final /* synthetic */ ab f6914f;

    ac(ab abVar, int i, int i2, int i3, int i4) {
        this.f6914f = abVar;
        this.f6910b = i;
        this.f6911c = i2;
        this.f6912d = i3;
        this.f6913e = i4;
    }

    public void run() {
        if (!this.f6914f.f6904d.hasEnded() && this.f6914f.f6905e != this.f6910b) {
            this.f6914f.f6904d.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.f6909a);
            this.f6914f.f6905e = Math.round((((float) (this.f6910b - this.f6911c)) * this.f6909a.getAlpha()) + ((float) this.f6911c));
            this.f6914f.f6906f = Math.round((((float) (this.f6912d - this.f6913e)) * this.f6909a.getAlpha()) + ((float) this.f6913e));
            this.f6914f.invalidateSelf();
            UThread.post((Runnable) this);
        } else if (this.f6914f.f6907g && this.f6911c > this.f6910b) {
            this.f6914f.f6907g = this.f6910b > this.f6911c;
            this.f6914f.m10210d();
            this.f6914f.invalidateSelf();
        }
    }
}
