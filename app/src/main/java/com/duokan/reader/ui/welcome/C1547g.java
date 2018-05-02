package com.duokan.reader.ui.welcome;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;

/* renamed from: com.duokan.reader.ui.welcome.g */
public class C1547g extends C1541a {
    /* renamed from: a */
    private final int f11612a = 1;
    /* renamed from: b */
    private final int f11613b = 1000;
    /* renamed from: c */
    private final Runnable f11614c = new C1548h(this);

    public C1547g(Context context, Runnable runnable) {
        super(context, runnable);
    }

    /* renamed from: a */
    public void mo2565a(long j) {
        super.m15562a(j, new C1549i(this));
    }

    /* renamed from: a */
    public void mo2566a(boolean z) {
        removeCallbacks(this.f11614c);
        super.mo2566a(z);
    }

    /* renamed from: a */
    private void m15564a() {
        m15565a(getChildAt(0), 0, 0, -1, 1);
    }

    /* renamed from: a */
    private void m15565a(View view, int i, int i2, int i3, int i4) {
        Animation translateAnimation = new TranslateAnimation((float) i, (float) i2, (float) i3, (float) i4);
        translateAnimation.setFillAfter(false);
        translateAnimation.setDuration(200);
        translateAnimation.setInterpolator(new CycleInterpolator(1.0f));
        view.startAnimation(translateAnimation);
        postDelayed(this.f11614c, 1000);
    }
}
