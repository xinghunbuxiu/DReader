package com.duokan.reader.ui.welcome;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;

import miuipub.date.Calendar;

public class g extends a {
    private final int a = 1;
    private final int b = Calendar.MILLISECOND_OF_SECOND;
    private final Runnable c = new h(this);

    public g(Context context, Runnable runnable) {
        super(context, runnable);
    }

    public void a(long j) {
        super.a(j, new i(this));
    }

    public void a(boolean z) {
        removeCallbacks(this.c);
        super.a(z);
    }

    private void a() {
        a(getChildAt(0), 0, 0, -1, 1);
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        Animation translateAnimation = new TranslateAnimation((float) i, (float) i2, (float) i3, (float) i4);
        translateAnimation.setFillAfter(false);
        translateAnimation.setDuration(200);
        translateAnimation.setInterpolator(new CycleInterpolator(1.0f));
        view.startAnimation(translateAnimation);
        postDelayed(this.c, 1000);
    }
}
