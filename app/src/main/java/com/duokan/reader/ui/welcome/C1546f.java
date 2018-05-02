package com.duokan.reader.ui.welcome;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* renamed from: com.duokan.reader.ui.welcome.f */
class C1546f implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ Runnable f11610a;
    /* renamed from: b */
    final /* synthetic */ C1541a f11611b;

    C1546f(C1541a c1541a, Runnable runnable) {
        this.f11611b = c1541a;
        this.f11610a = runnable;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f11610a != null) {
            this.f11611b.post(this.f11610a);
        }
    }
}
