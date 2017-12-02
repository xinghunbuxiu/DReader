package com.duokan.reader.ui.general;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class gt implements AnimationListener {
    final /* synthetic */ gr a;
    private final Runnable b;
    private final Runnable c;
    private final int d;
    private final Handler e = new Handler();
    private int f = 0;

    public gt(gr grVar, int i, Runnable runnable, Runnable runnable2) {
        this.a = grVar;
        this.d = i;
        this.b = runnable;
        this.c = runnable2;
    }

    public void onAnimationStart(Animation animation) {
        if (this.b != null) {
            this.b.run();
        }
        if (this.a.i) {
            new gu(this, animation).run();
        }
    }

    public void onAnimationEnd(Animation animation) {
        if (!this.a.i && this.c != null) {
            this.c.run();
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
