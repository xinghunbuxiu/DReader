package com.duokan.reader.ui.welcome;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;

import java.util.Timer;
import java.util.TimerTask;

public abstract class a extends FrameLayout {
    private final Runnable a;
    private Timer b;
    private TimerTask c;
    private boolean d = false;

    public a(Context context, Runnable runnable) {
        super(context);
        this.a = runnable;
    }

    public void a(long j) {
        a(j, null);
    }

    public void a(long j, Runnable runnable) {
        a(this, 0, 1, new b(this, j, runnable));
    }

    public void a(boolean z) {
        if (this.b != null) {
            this.b.cancel();
        }
        if (z) {
            a();
        } else if (!this.d) {
            this.d = true;
            a(getChildAt(0), 1, 0, new e(this));
        }
    }

    private void a() {
        clearAnimation();
        getChildAt(0).clearAnimation();
        setVisibility(4);
        if (this.a != null) {
            this.a.run();
            this.d = false;
        }
    }

    private void a(View view, int i, int i2, Runnable runnable) {
        Animation alphaAnimation = new AlphaAnimation((float) i, (float) i2);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(500);
        getChildAt(0).startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new f(this, runnable));
    }
}
