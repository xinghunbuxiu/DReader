package com.duokan.reader.ui.welcome;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.duokan.reader.ui.welcome.a */
public abstract class C1541a extends FrameLayout {
    /* renamed from: a */
    private final Runnable f11600a;
    /* renamed from: b */
    private Timer f11601b;
    /* renamed from: c */
    private TimerTask f11602c;
    /* renamed from: d */
    private boolean f11603d = false;

    public C1541a(Context context, Runnable runnable) {
        super(context);
        this.f11600a = runnable;
    }

    /* renamed from: a */
    public void mo2565a(long j) {
        m15562a(j, null);
    }

    /* renamed from: a */
    public void m15562a(long j, Runnable runnable) {
        m15558a(this, 0, 1, new C1542b(this, j, runnable));
    }

    /* renamed from: a */
    public void mo2566a(boolean z) {
        if (this.f11601b != null) {
            this.f11601b.cancel();
        }
        if (z) {
            m15557a();
        } else if (!this.f11603d) {
            this.f11603d = true;
            m15558a(getChildAt(0), 1, 0, new C1545e(this));
        }
    }

    /* renamed from: a */
    private void m15557a() {
        clearAnimation();
        getChildAt(0).clearAnimation();
        setVisibility(4);
        if (this.f11600a != null) {
            this.f11600a.run();
            this.f11603d = false;
        }
    }

    /* renamed from: a */
    private void m15558a(View view, int i, int i2, Runnable runnable) {
        Animation alphaAnimation = new AlphaAnimation((float) i, (float) i2);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(500);
        getChildAt(0).startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new C1546f(this, runnable));
    }
}
