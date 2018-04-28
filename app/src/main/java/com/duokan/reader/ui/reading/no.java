package com.duokan.reader.ui.reading;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.duokan.core.sys.UThread;

class no implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ Runnable f10685a;
    /* renamed from: b */
    final /* synthetic */ nh f10686b;

    no(nh nhVar, Runnable runnable) {
        this.f10686b = nhVar;
        this.f10685a = runnable;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        UThread.post(this.f10685a);
    }
}
